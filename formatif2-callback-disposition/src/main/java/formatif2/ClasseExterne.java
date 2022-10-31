package formatif2;

public class ClasseExterne implements SimpleCallBack.Methode1{

    @Override
    public String fait(String val) {
        return "méthode normale de ClasseExterne " + val;
    }
}
