package com.bitwise.drawingcanvas_main;
// commit by jais

public class CreatePattern  extends Canvas{


    public void createPatternOnCanvas(char ch, int x1, int y1, int x2, int y2){

        if(x1<0 || y1<0 || x2<0 || y2<0)
        {
            throw new Canvas.OutOfBoundException();
        }

        if(x1<1 || y1<1 || x2<1 || y2<1)
        {
            throw new Canvas.OutOfBoundException();
        }
        if(ch=='L')
        {
            createLine(x1,y1,x2,y2);
        }
        if(ch=='R')
        {
            createRectangle(x1,y1,x2,y2);
        }
    }
    private void createRectangle(int x1, int y1, int x2, int y2)  {

        createLine(x1,y1,x2,y1);
        createLine(x1,y1,x1,y2);
        createLine(x2,y1,x2,y2);
        createLine(x1,y2,x2,y2);
    }
    private void createLine(int x1, int y1, int x2, int y2)
    {
        if(x1!=x2 && y1!=y2)  throw new OutOfBoundException();
        if(x1==x2)//Vertical line
        {
            int c=y1;
            while(c<=y2)
            {
                buffer.replace(getIndex(c,x1),getIndex(c,x1)+1,"x");
                c++;
            }

        }
        if(y1==y2)//Horizontal line
        {
            int c=x1;
            while(c<=x2)
            {
                buffer.replace(getIndex(y1, c),getIndex(y1, c)+1,"x");
                c++;
            }
        }

    }
    @SuppressWarnings("static-access")
    private int getIndex(int r, int c)
    {
        int index;
        index=c+((this.width+2)*r)+r;
        return index;
    }
    public void fillPattern()
    {
        findAdjecentPixelIndex(3, 10, "O");
    }
    private void findAdjecentPixelIndex(int y, int x, String color)
    {
        if(buffer.charAt(getIndex(y, x))==' ')
        {
            buffer.replace(getIndex(y, x),getIndex(y, x)+1,color);
            findAdjecentPixelIndex(y,x-1,color);
            findAdjecentPixelIndex(y,x+1,color);
            findAdjecentPixelIndex(y-1,x,color);
            findAdjecentPixelIndex(y+1,x,color);
        }

    }
    public void printPattern()
    {
        System.out.println(buffer);
    }
}

