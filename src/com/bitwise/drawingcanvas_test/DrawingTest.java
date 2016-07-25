package com.bitwise.drawingcanvas_test;
// commit by jais
        import com.bitwise.drawingcanvas_main.Canvas;
        import com.bitwise.drawingcanvas_main.CreatePattern;
        import org.junit.Test;

        import static org.junit.Assert.assertEquals;


public class DrawingTest {
    @Test
    public void itShouldCheckLengthOfCanvas()
    {
        Canvas canvas=new Canvas();
        assertEquals(183,canvas.createCanvas('C',20,6).length());
    }
    @Test(expected=Canvas.OutOfBoundException.class)
    public void itShouldCheckNegativeValuesForCanvas() throws Exception
    {
        Canvas canvas=new Canvas();
        canvas.createCanvas('c', -4,0);
    }
    @Test(expected=Canvas.OutOfBoundException.class)
    public void itShouldCheckNegativeValuesForCoordinates()
    {
        Canvas canvas=new Canvas();
        CreatePattern pattern = new CreatePattern();
        canvas.createCanvas('C',20,6);
        pattern.createPatternOnCanvas('L', 10,20,-3,3);
    }
    @Test
    public void itShouldCreateCanvas()
    {
        Canvas canvas=new Canvas();
        CreatePattern pattern = new CreatePattern();
        canvas.createCanvas('C',20,4);
        pattern.createPatternOnCanvas('L',1,2,6,2);
        pattern.createPatternOnCanvas('L',6,3,6,4);
        pattern.createPatternOnCanvas('R',16,1,20,3);
        pattern.fillPattern();
        pattern.printPattern();

    }

}