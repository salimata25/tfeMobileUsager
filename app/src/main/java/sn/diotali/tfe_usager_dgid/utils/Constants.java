package sn.diotali.tfe_usager_dgid.utils;

import sn.diotali.tfe_usager_dgid.types.TransactionRequest;
import sn.diotali.tfe_usager_dgid.types.User;

public class Constants {

    public static String BASE_URL = "https://192.168.1.51:8031/tfe/access/mobile/";

    public static void newURL(final String ADDRESS_IP){
        BASE_URL = "http://" + ADDRESS_IP +":8031/tfe/access/mobile/";
    }

    public static final String QR_CODE_KEY = "6AC292FAA1315B4D858AB3A3D7D5933A";


    public static  class Methods{
        public static final String ACHETER_TIMBRE = "acheter/timbre";
        public static final String ACHETER_QUITTANCE = "acheter/quittance";
        public static final String LOGIN = "connexion";
        public static final String INSCRIRE = "usager/inscrire";
        public static final String ACTIVERCOMPTE = "usager/inscrire/validation";
    }

    public static class Menu {
        public static final String TIMBRE = "TIMBRE";
        public static final String QUITTANCE = "QUITTANCE";
    }

    public static class ResponseStatus {
        public static final int OK = 0;
    }

    public class ExtrasName {
        public static final String STATUS = "STATUS";
        public static final String MESSAGE = "MESSAGE";
        public static final String TICKET_INFOS = "TICKET_INFOS";
    }

    public class PaymentMeans {
        public static final String CASH = "CASH";
    }

    public class ActivityRequest {
        public static final int RECAPITULATIF = 1;
        public static final int PRINT_CHOICE = 3;
        public static final int FINAL_DISPLAY = 4;
        public static final int REQUEST_CONNECT_BT_PRINTER = 10;
    }

    public class ResponseActivty {
        public static final int OK = 1;
        public static final int NOK = 0;
        public static final int FAILED = -999;
    }

    public static User newUser;
    public static TransactionRequest newTransaction;


}
