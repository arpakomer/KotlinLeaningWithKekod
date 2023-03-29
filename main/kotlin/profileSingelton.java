


class profileSingelton {

            // En temiz hali

    private volatile static profileSingelton profile;

    private profileSingelton() {

    }

   public synchronized static profileSingelton newInstance() {
        if (profile == null){
            profile = new profileSingelton();
        }

        return profile;
   }


   public  String name;

   private int counter;

  public int getCounter() {
      return counter;
  }
  public  void  setCounter(int increasedValue) {
      counter += increasedValue;
  }
}

