package profileapp;


/**
* profileapp/TopTen.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ./tasteprofile.idl
* lundi 25 septembre 2017 15 h 11 CEST
*/


/* Type for top ten users */
public abstract class TopTen implements org.omg.CORBA.portable.StreamableValue
{
  /**
	 * 
	 */
	private static final long serialVersionUID = 6629911221828767407L;

public profileapp.User topTenUsers[] = null;

  private static String[] _truncatable_ids = {
    profileapp.TopTenHelper.id ()
  };

  public String[] _truncatable_ids() {
    return _truncatable_ids;
  }

  public void _read (org.omg.CORBA.portable.InputStream istream)
  {
    int _len0 = istream.read_long ();
    this.topTenUsers = new profileapp.User[_len0];
    for (int _o1 = 0;_o1 < this.topTenUsers.length; ++_o1)
      this.topTenUsers[_o1] = profileapp.UserHelper.read (istream);
  }

  public void _write (org.omg.CORBA.portable.OutputStream ostream)
  {
    ostream.write_long (this.topTenUsers.length);
    for (int _i0 = 0;_i0 < this.topTenUsers.length; ++_i0)
      profileapp.UserHelper.write (ostream, this.topTenUsers[_i0]);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return profileapp.TopTenHelper.type ();
  }
} // class TopTen
