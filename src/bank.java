import java.util.Scanner;
public class bank {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        double [] account_number={119001167,119001166,119001161,119001160,119001154,119001134,119001129};
        double [] account_balance={10000,15000,10000,5000,20000,20000,50000};
        double [] account_pin={1234,1234,1234,1234,1234,1234,1234};
        String [] account_holder={"Ratnojit Saha","Rimi Dutta","Sayan Das","Swarnadeep S P","Rupanjana Ghosh","Priya Biswas","Sayandip Das"};
        final int loop=10;
        while(loop==10) {
            System.out.println("");
            System.out.println("Welcome To SSP Bank");
            System.out.print("Enter Account Number:- ");
            double acc_num = sc.nextDouble();
            System.out.print("Enter Account Pin:- ");
            double acc_pin = sc.nextDouble();
            int index = Auth(account_number, account_pin, acc_num, acc_pin);
            if (index != -1) {
                int ch = 1;
                while (ch != 6) {
                    System.out.println("");
                    System.out.println("Welcome " + account_holder[index]);
                    System.out.println("");
                    System.out.println("Enter Choice");
                    System.out.println("1.Check Balance");
                    System.out.println("2.Deposit Amount");
                    System.out.println("3.Withdrawl Amount");
                    System.out.println("4.Transfer Amount");
                    System.out.println("5.Change Pin");
                    System.out.println("6.Log Out");
                    ch = sc.nextInt();
                    if (ch == 1) {
                        System.out.println("Your Current Account Balance Is " + account_balance[index]);
                    }
                    else if (ch == 2) {
                        System.out.print("Enter Amount To Be Deposited:- ");
                        int deposit = sc.nextInt();
                        account_balance[index] = account_balance[index] + deposit;
                        System.out.println("Your Current Account Balance Is " + account_balance[index]);
                    }
                    else if (ch == 3) {
                        System.out.print("Enter Amount To Be Withdrawl:- ");
                        int withdrawl = sc.nextInt();
                        if (withdrawl > account_balance[index]) {
                            System.out.println("Insuffcient Balance");
                            System.out.println("Logged Out Sucessfully");
                            break;
                        }
                        else {
                            account_balance[index] = account_balance[index] - withdrawl;
                            System.out.println("Your Current Account Balance Is " + account_balance[index]);
                        }
                    }
                    else if (ch == 4){
                        System.out.print("Enter Account Number To be Transfered:- ");
                        double trans_acc=sc.nextDouble();
                        System.out.println("Enter Amount To be Transfered");
                        double trans_amount=sc.nextDouble();
                        int trans_index=-1;
                        trans_index=Transfer(account_number,trans_acc);
                        if (trans_index!=-1)
                        {
                            if (trans_amount<=account_balance[index]){
                                account_balance[index]=account_balance[index]-trans_amount;
                                account_balance[trans_index]=account_balance[trans_index]+trans_amount;
                                System.out.println("Transfer Sucessfully");
                                System.out.println("Your Current Account Balance Is " + account_balance[index]);
                            }
                            else
                            {
                                System.out.println("Insufficient Balance");
                            }
                        }
                        else
                        {
                            System.out.println("In-Correct Account Number");
                        }
                    }
                    else if (ch == 5) {
                        System.out.print("Enter Old Pin");
                        int old_pin = sc.nextInt();
                        if (old_pin == account_pin[index]) {
                            System.out.print("Enter New Pin");
                            int new_pin1 = sc.nextInt();
                            System.out.print("Re-Enter New Pin");
                            int new_pin2 = sc.nextInt();
                            if (new_pin1 == new_pin2) {
                                account_pin[index] = new_pin1;
                                System.out.println("Pin Changed Sucessfully");
                                System.out.println("Logged Out Sucessfully");
                                break;
                            }
                            else {
                                System.out.println("Two Entered Pin Are In-Correct");
                            }
                        }
                        else {
                            System.out.println("Incorrect Old Pin");
                        }

                        }
                }
            }
            else {
                System.out.println("Enter Correct Credentials");
            }
        }
    }
    static int Auth(double [] account_number,double [] account_pin,double acc_num,double acc_pin){
        int index=-1;
        for(int i=0;i<account_number.length;i++){
            if(account_number[i]==acc_num ){
                if(account_pin[i]==acc_pin) {
                    index = i;
                    break;
                }
            }
        }
        return index;
    }
    static int Transfer(double [] account_number,double acc_num){
        int index=-1;
        for(int i=0;i<account_number.length;i++){
            if(account_number[i]==acc_num ){
                    index = i;
                    break;
            }
        }
        return index;
    }
}