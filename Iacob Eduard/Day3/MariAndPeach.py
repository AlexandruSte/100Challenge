#Princess Peach is trapped in one of the four corners of a square grid. You are in the center of the grid and can move one step at a time in any of the four directions. Can you rescue the princess? 
#Complete the function displayPathtoPrincess which takes in one parameter - the character array grid. The grid will be formatted exactly as you see it in the input, so for the sample input the princess is at grid[2][0]. 
#The function shall output moves (LEFT, RIGHT, UP or DOWN) on consecutive lines to rescue/reach the princess. The goal is to reach the princess in as few moves as possible.
#The above sample input is just to help you understand the format. The princess ('p') can be in any one of the four corners.
def displayPathtoPrincess(grid):
  m_x,m_y = 0,0
  pr_x,pr_y = 0,0
  for i in range(0,len(grid)):
    for j in range(0,len(grid[i])):
      if grid[i][j] == 'm':
        m_x,m_y = i,j
      elif grid[i][j] == 'p':
        pr_x,pr_y = i,j
  nrows = pr_x - m_x
  ncols = pr_y - m_y
  
  return ''.join([
    'UP\n' * abs(nrows) if nrows < 0 else 'DOWN\n' * nrows,
    'LEFT\n' * abs(ncols) if ncols < 0 else 'RIGHT\n' * ncols])
grid = [['-','-','-'],['-','m','-'],['p','-','-']]
print(displayPathtoPrincess(grid))

#Result: 
#DOWN
#LEFT
