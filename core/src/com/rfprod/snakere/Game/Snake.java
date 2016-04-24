package com.rfprod.snakere.Game;

import java.util.Iterator;
import java.util.LinkedList;


/**
 * Player.
 * Snake like avatar. will begin as a single link? (the head) as the snake collects materials he will be come longer.
 * Snake will collide with its self and the wall.
 *
 * Use a linked list of vector2? Can follow through for position. Will never have to remove as object will only grown in length.
 *
 */
public class Snake {


    public static final int NOT_SET = 0;
    public static final int NORTH = 1;
    public static final int EAST = 2;
    public static final int SOUTH = 3;
    public static final int WEST = 4;

    public static final int DEFAULT_SPEED = 1;


    private LinkedList<BodySegment> snake;
    private int lastDirection;
    private int currentDirection;
    private int speed;

    private int lastX,lastY;
    private int tempX,tempY;







    public Snake(int x, int y)
    {

        snake = new LinkedList<BodySegment>();

        snake.add(new BodySegment(x,y));
        lastDirection = NOT_SET;
        currentDirection = NOT_SET;
        speed = DEFAULT_SPEED;



    }


    public void changeDirectionNorth()
    {
        if (this.currentDirection != NORTH)
        {
            lastDirection = currentDirection;
            currentDirection = NORTH;
        }
    }

    public void changeDirectionWest()
    {
        if (this.currentDirection != WEST)
        {
            lastDirection = currentDirection;
            currentDirection = WEST;
        }
    }

    public void changeDirectionEast()
    {
        if (this.currentDirection != EAST)
        {
            lastDirection = currentDirection;
            currentDirection = EAST;
        }
    }

    public void changeDirectionSouth()
    {
        if (this.currentDirection != SOUTH)
        {
            lastDirection = currentDirection;
            currentDirection = SOUTH;
        }
    }

    public BodySegment getHead()
    {
        return this.snake.getFirst();
    }

    public void addBodySegment(int x, int y)
    {
        snake.add(new BodySegment(x,y));
    }


    public void move()
    {

        Iterator<BodySegment> it = this.snake.listIterator();
        boolean headMoved = false;
        BodySegment currentSegment;



        while(it.hasNext())
        {
            currentSegment = it.next();


            if(!headMoved)
            {
                lastX = currentSegment.getX();
                lastY = currentSegment.getY();
                moveHead(currentSegment);

                headMoved = true;
            }
            else
            {
                tempX = currentSegment.getX();
                tempY = currentSegment.getY();


                currentSegment.move(lastX,lastY);

                lastX  = tempX;
                lastY = tempY;


            }
        }

    }

    private void moveHead(BodySegment head)
    {
        switch(currentDirection)
        {
            case NORTH:
                head.move(head.getX(),head.getY() + 1);
                break;
            case SOUTH:
                head.move(head.getX(),head.getY() -1);
                break;
            case EAST:
                head.move(head.getX() +1 , head.getY());
                break;
            case WEST:
                head.move(head.getX() - 1, head.getY());
                break;
        }
    }



    public int getCurrentDirection()
    {return this.currentDirection;}

    public Iterator<BodySegment> bodySegmentIterator()
    {
        return this.snake.listIterator();
    }










}