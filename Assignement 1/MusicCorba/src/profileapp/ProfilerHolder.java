package profileapp;

/**
* profileapp/ProfilerHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ./tasteprofile.idl
* lundi 25 septembre 2017 15 h 11 CEST
*/


/* The service interface with the methods that can be invoked remotely by clients */
public final class ProfilerHolder implements org.omg.CORBA.portable.Streamable
{
  public profileapp.Profiler value = null;

  public ProfilerHolder ()
  {
  }

  public ProfilerHolder (profileapp.Profiler initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = profileapp.ProfilerHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    profileapp.ProfilerHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return profileapp.ProfilerHelper.type ();
  }

}
