package Model;

public class CalcResultData extends Data<String> {
    private String calcResultData;

    public CalcResultData() {
        this.calcResultData = "";
    }

    public String getData() {
        return calcResultData;
    }

    public void setData(ComplexNumber cn1, ComplexNumber cn2, ComplexNumber result, char activity) {
        this.calcResultData = cn1.toString() + " " + activity + " " + cn2.toString() + " = " + result.toString();;
    }

}
