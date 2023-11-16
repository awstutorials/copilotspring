# Python code to count and display number of vowels
# Simply using for and comparing it with a 
# string containing all vowels
# def Check_Vow(string, vowels):
# 	final = [each for each in string if each in vowels]
# 	print(len(final))
# 	print(final)
	
# Driver Code
# string = "Geeks for Geeks"
# vowels = "AaEeIiOoUu"
# Check_Vow(string, vowels);

def compound_interest(principle, roi, time) :
    amount = principle*((1+roi/100)**time)
    interest=amount-principle
    print("Final amount :", amount)
    print("Compount Interest: ", interest)

compound_interest(10000,10,10)