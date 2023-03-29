


public class ProfileTest {
    public  static  void  main (String[] args){
//        Profile profile1 = new Profile();


//        Profile.newInstance;

        //thread1
        profileSingelton profile = profileSingelton.newInstance();
        profile.setCounter(1);
        //thread2
        profileSingelton profile2 = profileSingelton.newInstance();
        profile2.setCounter(1);
        //thread3
        profileSingelton profile3 = profileSingelton.newInstance();
        profile3.setCounter(1);

        System.out.println(profile.getCounter());
        System.out.println(profile2.getCounter());
        System.out.println(profile3.getCounter());




    }


}
