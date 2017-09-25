package profileapp;


/**
* profileapp/Song.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ./tasteprofile.idl
* lundi 25 septembre 2017 15 h 11 CEST
*/


/* Type for a Song */
public abstract class Song implements org.omg.CORBA.portable.StreamableValue
{
  public String id = null;
  public int play_count = (int)0;

  private static String[] _truncatable_ids = {
    profileapp.SongHelper.id ()
  };

  public String[] _truncatable_ids() {
    return _truncatable_ids;
  }

  public void _read (org.omg.CORBA.portable.InputStream istream)
  {
    this.id = istream.read_string ();
    this.play_count = istream.read_long ();
  }

  public void _write (org.omg.CORBA.portable.OutputStream ostream)
  {
    ostream.write_string (this.id);
    ostream.write_long (this.play_count);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return profileapp.SongHelper.type ();
  }
} // class Song
