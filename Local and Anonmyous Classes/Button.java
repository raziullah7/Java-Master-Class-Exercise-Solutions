public class Button {
    // fields
    private String title;
    private OnClickListener onClickListener;

    // constructor
    public Button(String title) {
        this.title = title;
    }

    // getter
    public String getTitle() {
        return title;
    }

    // setter
    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    // method
    public void onClick() {
        this.onClickListener.onClick(this.title);
    }

    // interface
    public interface OnClickListener {
        public void onClick(String title);
    }
}
