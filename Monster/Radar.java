
/**
 * The model for radar scan and accumulator
 * 
 * @author @gcschmit
 * @version 19 July 2014
 */
public class Radar
{
    
    // stores whether each cell triggered detection for the current scan of the radar
    private boolean[][] currentScan;
    private boolean[][] prevScan;
    
    // value of each cell is incremented for each scan in which that cell triggers detection 
    private int[][] accumulator;
    
    // location of the monster
    private int monsterLocationRow;
    private int monsterLocationCol;
    
    // dx and dy values
    private int rowMove;
    private int colMove;
    // probability that a cell will trigger a false detection (must be >= 0 and < 1)
    private double noiseFraction;
    
    // number of scans of the radar since construction
    private int numScans;

    /**
     * Constructor for objects of class Radar
     * 
     * @param   rows    the number of rows in the radar grid
     * @param   cols    the number of columns in the radar grid
     */
    public Radar(int rows, int cols, int dx, int dy)
    {
        // initialize instance variables
        currentScan = new boolean[rows][cols]; // elements will be set to false
        prevScan = new boolean[rows][cols];
        
        accumulator = new int[rows][cols]; // elements will be set to 0
        
        // randomly set the location of the monster (can be explicity set through the
        //  setMonsterLocation method
        monsterLocationRow = (int)(Math.random() * rows);
        monsterLocationCol = (int)(Math.random() * cols);
        
        rowMove = dx;
        colMove = dy;
        
        noiseFraction = 0.5;
        numScans= 0;
    }
    
        /**
         * Performs a scan of the radar. Noise is injected into the grid and the accumulator is updated.
         * 
         */
        public void scan(int dx, int dy)
        {
                for(int row = 0; row < currentScan.length; row++)
                {
                    for(int col = 0; col < currentScan[0].length; col++)
                    {
                        currentScan[row][col] = false;
                    }
                }
                
                for (int row = 0; row < currentScan.length; row++)
                {
                    for (int col = 0; col < currentScan[0].length; col++)
                    {
                        if (currentScan[row][col] == true && prevScan[row][col] == true)
                        {
                            System.out.println("Pos");
                            for (int row2 = 0; row2 < prevScan.length; row2++)
                            {
                                for (int col2 = 0; col2 < prevScan[0].length; col2++)
                                {
                                    System.out.println("Positive");
                                    int dxchecker = row - row2;
                                    int dychecker = col - col2;
                                    if (dxchecker == dx && dychecker == dy)
                                    {
                                        String monsterReturn = "The monster's dx is" + dx + "and the monster's dy is "+ dy;
                                        System.out.println(monsterReturn);
                                    }
                                }
                            }
                        }
                    }
                }
            
                
                       
                //detect the monster
                if (monsterLocationRow < 99 && monsterLocationCol < 99)
                {
                    currentScan[monsterLocationRow][monsterLocationCol] = true;
                }        
                //inject noise into the grid
                injectNoise();
                
                //udpate the accumulator
                for(int row = 0; row < currentScan.length; row++)
                {
                    for(int col = 0; col < currentScan[0].length; col++)
                    {
                        if(currentScan[row][col] == true)
                        {
                           accumulator[row][col]++;
                        }
                    }
                }
    
            
            
                for(int row = 0; row < currentScan.length; row++)
                {
                    for(int col = 0; col < currentScan[0].length; col++)
                    {
                        if(currentScan[row][col] == true)
                        {
                           accumulator[row][col]++;
                        }
                    }
                }
            
            
    
             //Move the monster
             moveMonster();
    
                
        
                //Move the monster
                 moveMonster();
        
                
                 //keep track of the total number of scans
                    numScans++;
            }
        
        public void moveMonster()
        {
            monsterLocationRow = monsterLocationRow + rowMove;
            monsterLocationCol = monsterLocationCol + colMove;
        }
        
        public String getMonsterStats(int dx, int dy)
        {
            String positions = new String(dx+", "+dy);
            System.out.println(positions);
            return positions;
        }
        
        /**
         * Sets the location of the monster
         * 
         * @param   row     the row in which the monster is located
         * @param   col     the column in which the monster is located
         * @pre row and col must be within the bounds of the radar grid
         */
        public void setMonsterLocation(int row, int col)
        {
            // remember the row and col of the monster's location
            monsterLocationRow = row;
            monsterLocationCol = col;
            
            // update the radar grid to show that something was detected at the specified location
            currentScan[row][col] = true;
        }
        
        public void setprevScan()
        {
            for(int row = 0; row < currentScan.length; row++)
            {
                for(int col = 0; col < currentScan[0].length; col++)
                {
                    prevScan[row][col] = currentScan[row][col];
                }
            }
        }
        
        /**
         * Sets the probability that a given cell will generate a false detection
         * 
         * @param   fraction    the probability that a given cell will generate a flase detection expressed
         *                      as a fraction (must be >= 0 and < 1)
         */
        public void setNoiseFraction(double fraction)
        {
            noiseFraction = fraction;
        }
        
        /**
         * Returns true if the specified location in the radar grid triggered a detection.
         * 
         * @param   row     the row of the location to query for detection
         * @param   col     the column of the location to query for detection
         * @return true if the specified location in the radar grid triggered a detection
         */
        public boolean isDetected(int row, int col)
        {
            return currentScan[row][col];
        }
        
        /**
         * Returns the number of times that the specified location in the radar grid has triggered a
         *  detection since the constructor of the radar object.
         * 
         * @param   row     the row of the location to query for accumulated detections
         * @param   col     the column of the location to query for accumulated detections
         * @return the number of times that the specified location in the radar grid has
         *          triggered a detection since the constructor of the radar object
         */
        public int getAccumulatedDetection(int row, int col)
        {
            return accumulator[row][col];
        }
        
        /**
         * Returns the number of rows in the radar grid
         * 
         * @return the number of rows in the radar grid
         */
        public int getNumRows()
        {
            return currentScan.length;
        }
        
        /**
         * Returns the number of columns in the radar grid
         * 
         * @return the number of columns in the radar grid
         */
        public int getNumCols()
        {
            return currentScan[0].length;
        }
        
        /**
         * Returns the number of scans that have been performed since the radar object was constructed
         * 
         * @return the number of scans that have been performed since the radar object was constructed
         */
        public int getNumScans()
        {
            return numScans;
        }
        
        /**
         * Sets cells as falsely triggering detection based on the specified probability
         * 
         */
        private void injectNoise()
        {
            for(int row = 0; row < currentScan.length; row++)
            {
                for(int col = 0; col < currentScan[0].length; col++)
                {
                    // each cell has the specified probablily of being a false positive
                    if(Math.random() < noiseFraction)
                    {
                        currentScan[row][col] = true;
                    }
                }
            }
        }
        
    }
