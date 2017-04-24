/*  Andrew Paschalis
*  Program/Database to store holiday details.
*/
import javax.swing.JOptionPane;//Import JOptionPane Library
import java.io.*;//Import all of the IO Library
class Holiday1 //class declaration (cannot be accessed by other java applications
{
    public static void main (String [] args) throws IOException

    {

        int option = 0;//declaration of int option with value of 0. runs the main menu option.
        String r;//String declaration.

        String Country []=new String [10];//Declaration of a String array with a size of 10. It stores the country name.
        String Description []= new String [10];//Declaration of a String array with a size of 10. It stores the Description of the holiday.
        double cost []= new double [10]; //Declaration of a double array with a size of 10. It stores the cost of the holiday.

        int holCount=0;// declaration of int holCount with a value of 0. It is used to keep track of the number of holidays being stored.

        //holCount=retrieve(Country, Description, cost, holCount);




        while (option!=8)// works until 8 is entered.
        {

            r = JOptionPane.showInputDialog(" 1.Enter a new entry \n 2.Search for an entry \n 3.Update an entry \n 4.Sort entries \n 5.Save data to a file \n 6.Retrieve data from a file \n 7.Print all entries \n 8.Exit \n Enter a number between 1-8");
            option = Integer.parseInt(r);    //used to print menu options using JOptionPane Input box, while also allowing the user to select which option they want. It then converts the String to an int so it can store the value in the option variable.


                if (option == 1)//when option is equal to 1.
                {

                    input(Country, Description, cost, holCount);//Goes to input method and sends the variables to that method.
                    holCount++;//adds a one to holCount;
                } else if (option == 2)//when option is equal to 2.
                {

                    String s = JOptionPane.showInputDialog("Enter the country you want to search for");//Tells the user to enter a country to search for using the JOption Input box.also declares String s.
                    int result = LinearSearch(Country, s, holCount);//sends the variables to the linearSearch method.and also declares int result and int result is equal to LinearSearch meaning the LinearSearch program needs to return an int back to the main menu.
                    if (result != -1) //when result is not equal to -1.
                    {
                        System.out.println("Country " + Country[result] + " is found in array at position: " + result);//prints out the country and what position it is stored at by using the System.out.println command.
                    } else { //when it is equal to -1.
                        System.out.println("Data is not found in array");//prints out no results where fonud using the System.out.println method.
                        //returns to the main menu options once complete.
                    }
                } else if (option == 3)//when option is equal to 3.
                {
                    Update(Country, Description, cost, holCount);//sends variables to Update method and goes to the Update method.
                } else if (option == 4)//when option is equal to 4.
                {
                    Bubble_Sort(Country, Description, cost, holCount);//sends variables to Bubble_Sort method and goes to the Bubble_sort method.
                } else if (option == 5)//when option is equal to 5.
                {
                    Save(Country, Description, cost, holCount); //sends variables to Save method and goes to the Save method.
                } else if (option == 6)//when option is equal to 6.
                {
                    holCount = retrieve(Country, Description, cost, holCount);// sends variables to retrieve method and goes to the retrieve method.
                } else if (option == 7)//when option is equal to 7.
                {
                    Print(Country, Description, cost, holCount);//sends variables to Print method and goes to the Print method.
                } else if (option > 8 || option < 1)//when option is bigger than 8 or smaller than 1.
                {
                    JOptionPane.showMessageDialog(null, "Error, enter a number between 1 and 8");//Displays error message using JOptionPane method.
                } else if (option == 8)//when option is equal to 8.
                {
                    JOptionPane.showMessageDialog(null, "Exiting.....");//Displays the message Exiting..... and then quits the program.
                }
        }




        }


    //---------------------------------------------------------------------------
    public static void input (String Country[],String Description[],double cost[],int holCount) throws IOException //input method declaration and declaration of the variables sent from main menu.
    {


        //  String Country1[]=new String [Country.length+1];//declares a new array and adds one to the length of the Country array.
        //	 String Description1[]=new String [Description.length+1];//declares a new array and adds one to the length of the Description array.
        //  double cost1[]=new double [cost.length+1];//declares a new array and adds one to the length of the cost array.

	   /*     for (int i=0; i<cost.length; i++)//for loop declaration
	         {
	            Country1[i]=Country[i];	//Country1[i] gets the value of Country[i]
	         	Description1[i]=Description[i];//Description1[i] gets the value of Description[i]
	         	cost1[i]=cost[i];//cost1[i] gets the value of Description[i]*/
        //  }



	      /* Country1[cost.length-1]=*/
            Country[holCount] = JOptionPane.showInputDialog("Choose Country");//Uses JOptionPane input box and asks the user to enter the country.
	      /* Description1[cost.length-1]=*/
            Description[holCount] = JOptionPane.showInputDialog("Enter Description");//Uses JOptionPane input box and asks the user to enter the description. uses holCount to keep a track of how many records have been entered.

            try {/*  cost1[cost.length-1]=*/
            cost[holCount] = Double.parseDouble(JOptionPane.showInputDialog("Cost of Holiday in GBP"));//Uses JOptionPane input box and asks the user to enter the cost. It also converts (parses) the JOptionPane to Double to store the value in the array cost[holCount].

            // cost=cost1;//resets counter.cost1 gives the value back to cost.
            // Description=Description1; //resets counter.
            //  Country=Country1;//resets counter.
            //  return cost[holCount];//returns value to main menu to change the array cost.
        } catch(NumberFormatException n)
        {
            JOptionPane.showMessageDialog(null,"Error please enter a number");
        }
    }





    //--------------------------------------------------------------------------

    public static int LinearSearch( String [] Country,String s,int holCount) throws IOException//linear search method declaration and declaration of variables sent from main menu.
    {
        for (int i = 0; i <holCount; i++)//runs for loop which runs up to the length of the Country.It declares i as the counter and also adds 1 each time the loop goes round.
        {
            if (Country[i].equals(s))//compares the values in the Country array and if it is the same the if statement executes.
            {
                return i; // return position to the main menu where the value has been found (e.g at position 0).
            }
        }  return -1;   // returns position to the main menu if the search value was not found.
    }

    //-------------------------------------------------------------------------------

    public static void Update (String Country[], String Description[], double cost [],int holCount) throws IOException //declaration of the Update method and declaration of the variables sent from the main menu.
    {
        int change=0;//declaration of the int change with a value of 0.

        for (int i=0; i<1; i++)//starts a for loop.
        {
            String a=JOptionPane.showInputDialog("What do you want to Update? \n 1.Country \n 2.Description \n 3.Cost \n 4.Return to Main Menu");
            int option=Integer.parseInt(a);
            // while (option !=4)
            // {
            if (option ==1)
            {
                String key=JOptionPane.showInputDialog("Enter Country you want to update");//Asks the user to enter the country they want to update using a JOptionPane Input box.
                if (Country[i].equals(key))//If the Country array is equal to the search key the user entered then the if statement executes.
                {
                    change=i;//change gets the value of i which stores the position of the counter in order to change the content in that position.
                    //asks the user to enter the new information to update the entry.
                    Country[i]=JOptionPane.showInputDialog("Enter Country");
                    JOptionPane.showMessageDialog(null,"Entry Updated!");//displays this when the entry has been updated.
                    //returns to the main menu once complete.
                }
                else if (!Country[i].equals(key)) // if Country[i] is not equal to key. if statement executes.
                {
                    System.out.println("Value not found in array");//System println statement printing value not found in array.
                    Update(Country,Description,cost,holCount);//Calls Update Method and sends values over. Recursion (method calls itself).

                }

            }
            else if (option == 2)//if option is equal to 2.
            {
                String key1=JOptionPane.showInputDialog("Enter Description you want to update");//asks the user to enter the description.
                if (Description[i].equals(key1))//if the description[i] is equal to key1 the if statement executes.
                {
                    change =i;//change gets the value of i.
                    Description[i]=JOptionPane.showInputDialog("Enter Country Description"); //enter the new information for Description.
                    JOptionPane.showMessageDialog(null,"Entry Updated!");//JOptionPane Entry updated.
                }
                else if (!Description[i].equals(key1))// if Description[i] is not equal to key1. if statement executes.
                {
                    System.out.println("Value not found in array");//System println statement printing value not found in array.
                    Update(Country,Description,cost,holCount);//calls Update method and sends values over.
                }

            }
            else if (option == 3)//option is equal to 3.
            {
                String key2=JOptionPane.showInputDialog("Enter cost");//asks the user to enter the cost they want to update.
                double keynum=Double.parseDouble(key2);//converts String to double.
                if (cost[i]==keynum)//if cost[i] is equal to keynum the if statement executes.
                {
                    change=i;//change gets the value of i.
                    String sCost=JOptionPane.showInputDialog("Enter Cost of holiday in GBP");//enter the new cost information.
                    cost[i]=Double.parseDouble(sCost);//converts String to Double.
                    JOptionPane.showMessageDialog(null,"Entry Updated!");//Message box displaying Entry Updated
                }
                else if (cost[i]!=keynum)//if cost[i] is not equal to keynum this if statement executes.
                {
                    System.out.println("Value not found in array");//System println statement printing value not found in array.
                    Update(Country,Description,cost,holCount);//calls this method.

                }

            }
        }

    }



    //-------------------------------------------------------------------------------

    public static void Bubble_Sort (String Country[], String Description[], double cost [],int holCount) throws IOException//Declaration of the Bubble_Sort method and declaration of the varibales sent from the main menu method.
    {
        int option=0; //declares option with a value of 0.
        while (option != 4)//runs while option is not equal to 4.
        {


            String a=JOptionPane.showInputDialog("Choose from the options \n 1.Sort by Country \n 2.Sort by Description \n 3.Sort by cost \n 4.Return to Main Menu");//menu options
            option=Integer.parseInt(a);//converts String to Integer.

            if (option == 1)// if option is equal to 1.
            {

                for (int p=0; p<holCount-1; p++)//start of the initial for loop.
                {
                    for (int k=0; k<holCount-1; k++)//start of another for loop inside the initial for loop.
                    {

                        if (Country[k].compareTo(Country[k+1])>0) //compares Country[k] with Country [k+1] and if Country is not in alphabetical order the if statement executes and if it is bigger than 0.
                        {
                            String t="";//Declaration of the String t with a value of "" null.
                            t=Country[k];//the value stored in Country gets moved to the value in t.
                            Country[k]=Country[k+1];//the value stored in Country[k] gets stored in the variable Country[k+1]
                            Country[k+1]=t;//the value in temp gets stored in the variable Country [k].
                        }
                        for (int m=0; m<holCount; m++) //declares a for loop.
                        {
                            System.out.println(Country[m]);//prints out the new values in cost.

                            //once complete it returns to the main menu.
                        }//end of for loop
                        System.out.println(); //creates a blank line using System.out
                        System.out.println("___________________________");//draws a line under each turn using System.out
                        System.out.println();//creates a blank line using System.out
                    }
                }
            }
            else if (option == 2)// if option is equal to 2.
            {
                for (int r=0; r<holCount-1; r++)//start of the initial for loop.
                {
                    for (int l=0; l<holCount-1; l++)//start of another for loop inside the initial for loop.
                    {

                        if (Description[l].compareTo(Description[l+1])>0)//compares Description[l] with Description [l+1] and if Description is not in alphabetical order the if statement executes and if it is bigger than 0.
                        {
                            String temp1="";//Declaration of the String temp1 with a value of "" null.
                            temp1=Description[l];//the value stored in Description gets moved to the value in temp.
                            Description[l]=Description[l+1];//the value stored in Description[l] gets stored in the variable Description[l+1]
                            Description[l+1]=temp1;//the value in temp1 gets stored in the variable Description [l].
                        }
                        for (int p=0; p<holCount; p++) //declares a for loop.
                        {
                            System.out.println(Description[p]);//prints out the new values in cost.

                            //once complete it returns to the main menu.
                        }//end of for loop
                        System.out.println(); //creates a blank line using System.out
                        System.out.println("___________________________");//draws a line under each turn using System.out
                        System.out.println();//creates a blank line using System.out

                    }
                }
            }
            else if (option == 3)
            {
                for (int pass=0; pass<holCount-1; pass++)//start of the initial for loop.
                {
                    for (int i=0; i<holCount-1; i++)//start of another for loop inside the initial for loop.
                    {

                        if (cost[i] > cost[i+1])//if the value in i+1 is bigger than i the if statement executes.
                        {
                            double temp=0;//Declaration of the double temp with a value of 0.
                            temp=cost[i];//the value stored in cost gets moved to the value in temp.
                            cost[i]=cost[i+1];//the value stored in cost[i] gets stored in the variable cost[i]
                            cost[i+1]=temp;//the value in temp gets stored in the variable cost [i].
                        }
                        for (int n=0; n<holCount; n++) //declares a for loop.
                        {
                            System.out.println(cost[n]);//prints out the new values in cost.

                            //once complete it returns to the main menu.
                        }//end of for loop
                        System.out.println(); //creates a blank line using System.out
                        System.out.println("___________________________");//draws a line under each turn using System.out
                        System.out.println();//creates a blank line using System.out
                    }
                }
            }
        }
    }
    //-------------------------------------------------------------------------------


    public static void Save (String Country[],String Description[], double cost[],int holCount)	 throws IOException //declaration of the method Save and the variables sent from the main menu are declared.
    {

        final FileWriter outputFile = new FileWriter ("Holiday.txt"); //creates a new file writer with stores information in a file named Country.doc
        final BufferedWriter outputBuffer = new BufferedWriter (outputFile); //creates a new buffered writer to write information to file.
        final PrintWriter Holiday= new PrintWriter (outputBuffer);//creates a new print writer called Holiday to print information to file.
        Holiday.println(holCount);//sends the value in holCount to the file.
        for (int i=0; i<holCount; i++)//start of for loop.
        {
            Holiday.println(Country[i]);//prints Country[i]

            Holiday.println(Description[i]);//prints Description[i]

            Holiday.println(cost[i]);//prints cost[i]

        }
        JOptionPane.showMessageDialog(null,"Save Successful!");

        Holiday.close();//closes Holiday PrintWriter.

    }



    //-------------------------------------------------------------------------------
    public static int retrieve (String Country[],String Description[], double cost[], int holCount) throws IOException //Declaration of the Variables sent from the main menu and declaration of the retrieve method. it returns an int.
    {
        try {
            final FileReader inputFile = new FileReader("Holiday.txt");//Creates new file reader to read from file Country.doc.
            final BufferedReader Hotel = new BufferedReader(inputFile);//creates new Buffered reader Hotel.

            holCount = Integer.parseInt(Hotel.readLine());//Hotel.readLine() is converted to double.

            for (int i = 0; i < holCount; i++)//for loop runs.
            {
                Country[i] = Hotel.readLine();//Country gets the value of Hotel.readLine().
                Description[i] = Hotel.readLine();//Description gets the value of Hotel.readLine().
                cost[i] = Double.parseDouble(Hotel.readLine());//Converts Hotel.readLine() to double and cost gets the value of Hotel.readLine().
            }

        }catch (FileNotFoundException f)
        {
            JOptionPane.showMessageDialog(null,"File not found, save the file first.");
        }
        return holCount; //returns holCount to the main method.
    }






    //-------------------------------------------------------------------------------
    public static void Print (String Country[],String Description[],double cost[],int holCount) throws IOException //Declaration of the print method and declaration of the variables sent from the main menu.
    {
        for (int i=0; i<holCount; i++) //for loop declaration
        {
            System.out.println(" The Country is: "+Country[i]+ " The Description is: " +Description[i]+ " The Cost is: " + cost[i]);	//pronts out the array values Country,Description,cost.
        }


    }
}
