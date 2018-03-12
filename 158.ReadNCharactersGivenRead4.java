/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    private int count = 0; //# of elements return from the read4 function
    private int pointer = 0; //index of our current position at current temp
    private char[] temp = new char[4]; //our temp buffer
    public int read(char[] buf, int n) {
        int index = 0;
        while (index < n) {
            if (pointer == 0) {
                count = read4(temp); //read in the next four characters
            }
            if (count == 0) { //we reach the end of the document
                break;
            }
            while (index < n && pointer < count) {  //meaning that we have characters in temp that we can transfer to buf
                buf[index++] = temp[pointer++];
            }
            if (pointer == count) {
                pointer = 0;
            }
        }
        return index;
    }
}
