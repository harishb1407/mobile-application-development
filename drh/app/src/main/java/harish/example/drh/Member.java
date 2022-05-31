package harish.example.drh;

public class Member {
    private Float edit_text_quantity;  //defining variables in order to receive input values into them to send them to the firebase db

    public Member() {
    }                                  //we use setter and getter to obtain the input values to send them to firebase db

    public Float getEdit_text_quantity() {
        return edit_text_quantity;
    }

    public void setEdit_text_quantity(Float edit_text_quantity) {
        this.edit_text_quantity = edit_text_quantity;
    }
}



