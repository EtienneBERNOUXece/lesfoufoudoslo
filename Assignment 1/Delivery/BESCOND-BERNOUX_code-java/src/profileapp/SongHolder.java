package profileapp;

/**
* profileapp/SongHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ./tasteprofile.idl
* lundi 25 septembre 2017 15 h 11 CEST
*/


/* Type for a Song */
public final class SongHolder implements org.omg.CORBA.portable.Streamable
{
  public profileapp.Song value = null;

  public SongHolder ()
  {
  }

  public SongHolder (profileapp.Song initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = profileapp.SongHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    profileapp.SongHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return profileapp.SongHelper.type ();
  }

}
