package com.ama.tourism_svg.Objects;

public class PictureText {

    private String title;
    private String background;

    public PictureText() {
    }

    public PictureText(String title, String background) {
        this.title = title;
        this.background = background;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }
}
