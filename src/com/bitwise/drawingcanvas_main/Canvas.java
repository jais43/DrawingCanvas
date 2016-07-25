package com.bitwise.drawingcanvas_main;

// commit by jais
@SuppressWarnings("ALL")
public class Canvas {

    @SuppressWarnings("static-access")


        protected static StringBuffer buffer;
        protected static int width;
        protected static int height;

        public StringBuffer createCanvas(char ch, int width, int height) {
            this.width=width;
            this.height=height;
            if(this.width<0 || this.height<0)

            {
                throw new OutOfBoundException();
            }

            buffer = new StringBuffer();
            if (ch == 'C') {
                for (int i = 0; i < height; i++) {
                    if (i == 0) for (int j = 0; j < width; j++)
                        if (j != width - 1) {
                            if (j == 0) {

                                buffer.append("--");
                            } else buffer.append("-");
                        } else {
                            buffer.append("--\n");
                        }

                    buffer.append("|");

                    for (int j = 0; j < width; j++) {
                        if (j == width - 1) {

                            buffer.append(" |\n");
                        } else {

                            buffer.append(" ");
                        }
                    }
                }
                for (int i = 0; i < width; i++) {
                    if (i == 0) {

                        buffer.append("--");
                    } else if (i == width - 1) {

                        buffer.append("--");
                    } else {

                        buffer.append("-");
                    }
                }

                System.out.println("");
            } else {
                System.out.println("invalid input");
            }
            return buffer;
        }
        public class OutOfBoundException extends RuntimeException {
        }

    }


