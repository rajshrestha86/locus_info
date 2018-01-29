package com.locus.locusinfo;

import java.io.Serializable;

/**
 * Created by pi on 1/28/18.
 */

public class stall_obj implements Serializable {
    public int _id;
    public String _name;
    public String _information;

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String get_name() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public String get_information() {
        return _information;
    }

    public void set_information(String _information) {
        this._information = _information;
    }


}
