package appx_homescreen.appx;

public class InputData {
    private int _id;
    private String _userName;
    private String _userPass;
    private String _fullName;

    public InputData(String userName, String userPass){
        this._userName = userName;
        this._userPass = userPass;
    }

    public InputData(String userName, String userPass, String fullName){
        this._userName = userName;
        this._userPass = userPass;
        this._fullName = fullName;
    }

    /** Setters */
    public void set_id(int _id) {
        this._id = _id;
    }
    public void set_userName(String _userName) {
        this._userName = _userName;
    }
    public void set_userPass(String _userPass) {
        this._userPass = _userPass;
    }
    public void set_fullName(String _fullName) {
        this._fullName = _fullName;
    }

    /** Getters */
    public int get_id() {
        return _id;
    }
    public String get_userName() {
        return _userName;
    }
    public String get_userPass() {
        return _userPass;
    }
    public String get_fullName() {
        return _fullName;
    }
}