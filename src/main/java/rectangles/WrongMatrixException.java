package rectangles;

public class WrongMatrixException extends Exception {
    public WrongMatrixException(){
        super("Matrix should contains only 0 or 1");
    }
}
