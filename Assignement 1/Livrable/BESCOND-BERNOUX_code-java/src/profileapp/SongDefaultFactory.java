package profileapp;

import model.SongImpl;

/**
* profileapp/SongDefaultFactory.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ./tasteprofile.idl
* lundi 25 septembre 2017 15 h 11 CEST
*/


/* Type for a Song */
public class SongDefaultFactory implements org.omg.CORBA.portable.ValueFactory {

  public java.io.Serializable read_value (org.omg.CORBA_2_3.portable.InputStream is)
  {
    return is.read_value(new SongImpl ("", -1));
  }
}
