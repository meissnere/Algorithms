package techQuestions;

public class IntegerEnglishWords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 0;
		
		System.out.println(numberToWords(num));
	}
	
	public static String numberToWords(int num) {
		String output = "";
		
		if (num == 0) {
			return "Zero";
		}
		
		int billion = num / 1000000000;
		if (billion >= 1) {
			System.out.println(billion);
			output = ones(billion) + " " + "Billion";
		}
		int million = num - (billion * 1000000000);
		million = million / 1000000;
		if (million >= 1) {
			if ((million / 100) >= 1) {
				output = output + " " + ones(million/100) + " Hundred";
			}
			if ((million % 100) >= 10 && (million % 100) < 20) {
				output = output + " " + tens(million % 100);
			} else if ((million % 100) >= 20 && (million % 100) < 100) {
				output = output + " " + twentyUp(((million%100)/10)*10);
				if (((million%100)%10) >= 0 && ((million%100)%10) <=9) {
					output = output + " " + ones((million%100)%10);
				}
			} else if (((million%100)%10) >= 0 && ((million%100)%10) <=9) {
				output = output + " " + ones((million%100)%10);
			}
			output = output + " Million";
		}
		
		int thousand = num - (billion * 1000000000) - (million * 1000000);
		thousand = thousand / 1000;
		if (thousand >= 1) {
			if ((thousand / 100) >= 1) {
				output = output + " " + ones(thousand/100) + " Hundred";
			}
			if ((thousand % 100) >= 10 && (thousand % 100) < 20) {
				output = output + " " + tens(thousand % 100);
			} else if ((thousand % 100) >= 20 && (thousand % 100) < 100) {
				output = output + " " + twentyUp(((thousand%100)/10)*10);
				if (((thousand%100)%10) >= 0 && ((thousand%100)%10) <=9) {
					output = output + " " + ones((thousand%100)%10);
				}
			} else if (((thousand%100)%10) >= 0 && ((thousand%100)%10) <=9) {
				output = output + " " + ones((thousand%100)%10);
			}
			output = output + " Thousand";
		}
		
		int hundred = num - (billion * 1000000000) - (million * 1000000) - (thousand * 1000);
		if (hundred >= 1) {
			if ((hundred / 100) >= 1) {
				output = output + " " + ones(hundred/100) + " Hundred";
			}
			if ((hundred % 100) >= 10 && (hundred % 100) < 20) {
				output = output + " " + tens(thousand % 100);
			} else if ((hundred % 100) >= 20 && (hundred % 100) < 100) {
				output = output + " " + twentyUp(((hundred%100)/10)*10);
				if (((hundred%100)%10) >= 0 && ((hundred%100)%10) <=9) {
					output = output + " " + ones((hundred%100)%10);
				}
			} else if (((hundred%100)%10) >= 0 && ((hundred%100)%10) <=9) {
				output = output + " " + ones((hundred%100)%10);
			}
		}
		
		
        return output.stripLeading();
    }
	
	public static String twentyUp(int num) {
		switch(num) {
			case 20: return "Twenty";
			case 30: return "Thirty";
			case 40: return "Forty";
			case 50: return "Fifty";
			case 60: return "Sixty";
			case 70: return "Seventy";
			case 80: return "Eighty";
			case 90: return "Ninety";
		}
		return "";
	}
	
	public static String tens(int num) {
		switch(num) {
			case 10: return "Ten";
			case 11: return "Eleven";
			case 12: return "Twelve";
			case 13: return "Thirteen";
			case 14: return "Fourteen";
			case 15: return "Fifteen";
			case 16: return "Sixteen";
			case 17: return "Seventeen";
			case 18: return "Eighteen";
			case 19: return "Nineteen";
		}
		return "";
	}
	
	public static String ones(int num) {
		String prefix = "";

		if (num == 1) {
			prefix = "One";
		} else if (num == 2) {
			prefix = "Two";
		} else if (num == 3) {
			prefix = "Three";
		} else if (num == 4) {
			prefix = "Four";
		} else if (num == 5) {
			prefix = "Five";
		} else if (num == 6) {
			prefix = "Six";
		} else if (num == 7) {
			prefix = "Seven";
		} else if (num == 8) {
			prefix = "Eight";
		} else if (num == 9) {
			prefix = "Nine";
		} else if (num == 0) {
            prefix = "Zero";
        }
		
		return prefix;
	}

}
