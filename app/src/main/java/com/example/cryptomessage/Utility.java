package com.example.cryptomessage;

import android.widget.Toast;
public class Utility {

/// ************************************************* CREATE MESSAGE *****************************************************************************//
    public static String createMessage(String message, String key){

        String new_Message = "";
        try {

            int flag = 0;

            char y = ' ';

            message = message.toUpperCase();
            int sectret_Key = Integer.parseInt(key);

            if(sectret_Key>26){
                sectret_Key = sectret_Key % 26;
            }else if(sectret_Key>=-26 && sectret_Key < 0){
                sectret_Key = -sectret_Key;
            }else if(sectret_Key < -26){
                sectret_Key = -sectret_Key;
                sectret_Key = sectret_Key % 26;
            }

            for(int i = 0; i<message.length();i++){

                char z = message.charAt(i);
                // If Logic starts here
                if((z>=65 && z<=90) || z==32){
                int x = (int)z;

                    if(x==32){
                        y = ' ';
                    }else{

                        x = x - 65;
                        x = x + sectret_Key;
                        if(x>=26)
                        {
                            x = x % 26;
                        }
                        x = x +65;
                }

                    //// If logic ends here
                    y = (char) x;
                }else{
                    y=z;
                }

                new_Message = new_Message + y;
            }

        } catch (Exception e) {

        }

        return new_Message;
    }


//// ******************************************************* READ MESSAGE *********************************************************************///
    public static String readMessage(String message, String key){

        String new_Message = "";

        try {

            int flag = 0;

            while(flag==0){

                char y = ' ';
                message = message.toUpperCase();

                int sectret_Key = Integer.parseInt(key);

                if(sectret_Key>26){
                    sectret_Key = sectret_Key % 26;
                }else if(sectret_Key>=-26 && sectret_Key < 0){
                    sectret_Key = -sectret_Key;
                }else if(sectret_Key < -26){
                    sectret_Key = -sectret_Key;
                    sectret_Key = sectret_Key % 26;
                }

                if(sectret_Key>0 && sectret_Key<26){
                    for(int i = 0; i<message.length();i++){
                        char z = message.charAt(i);
                        if((z>=65 && z<=90) || z==32) {

                            int x = (int) z;

                            if (x == 32) {
                                y = ' ';
                            } else {
                                x = x - 65;
                                x = x - sectret_Key;
                                if (x < 0) {
                                    x = x + 26;
                                }
                                x = x + 65;

                            }
                            /// If Logic Ends Here
                            y = (char) x;
                        }else{
                            y=z;
                        }

                        new_Message = new_Message + y;
                    }

                    flag++;

                }else{
                    flag = 0;
                }

            }

        } catch (Exception e) {
            // JOptionPane.showMessageDialog(null, e);
            System.out.println("Read Message Error = "+e);
        }

        return new_Message;
    }

}
