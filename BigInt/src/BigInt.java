public class BigInt {

    private String value;

    public BigInt(String value) {
        this.value = value;
    }

    public String sum(String value){
        String sum="";
        int s=0;
        for(int i=this.value.length()-1;i>=0;i--){
            s+=Character.getNumericValue(this.value.charAt(i)) + Character.getNumericValue(value.charAt(i));
            if(s>=10)
                sum = s%10 + sum;
            else
                sum= s+ sum;
            s/=10;
        }
        if(s!=0)
            sum = s+ sum;
        this.value=sum;
        return sum;
    }

    public String cross(String value){
        String multiplicationResult = "";
        for (int i = 0; i < this.value.length() + value.length(); i++) {
            multiplicationResult += "0";
        }

        char[] number1AsArray = this.value.toCharArray();
        char[] number2AsArray = value.toCharArray();
        int k = 0;
        for (int i = value.length() - 1; i >= 0 ; i--) {
            int carry = 0;
            String tempMultiplicationResult = "";

            for (int j = 0; j < k; j++) {
                tempMultiplicationResult = "0" + tempMultiplicationResult;
            }

            for (int j = this.value.length() - 1; j >= 0 ; j--) {
                int sum =
                        (Character.getNumericValue(number2AsArray[i]) * Character.getNumericValue(number1AsArray[j])) + carry;
                carry = sum / 10;
                sum = sum % 10;
                tempMultiplicationResult = sum + tempMultiplicationResult;
            }
            if (carry != 0)
                tempMultiplicationResult = carry + tempMultiplicationResult;

            String additionalResult = "";
            char[] tempAsArray = tempMultiplicationResult.toCharArray();
            char[] multResAsArray = multiplicationResult.toCharArray();
            carry = 0;
            int l = tempAsArray.length - 1;
            int m = multResAsArray.length - 1;
            while (l >= 0) {
                int a1 = Character.getNumericValue(tempAsArray[l]);
                int a2 = Character.getNumericValue(multResAsArray[m]);
                int sum = a1 + a2 + carry;
                carry = sum / 10;
                sum = sum - (carry * 10); // sum = sum % 10
                additionalResult = sum + additionalResult;
                l--;
                m--;
            }
            if (carry != 0)
                additionalResult = carry + additionalResult;

            multiplicationResult = multiplicationResult.substring(0, additionalResult.length()) + additionalResult;

            k++;
        }
        String s="";
        boolean flag=false;
        for(char c:multiplicationResult.toCharArray()){
            if(c != '0')
                flag = true;
            if(flag)
                s+=c;

        }
        this.value=s;
        return s;
    }

    public String minimize(String value){
        String sum="";
        int s=0;
        for (int i=this.value.length()-1;i<this.value.length();i++){
            s+=Character.getNumericValue(this.value.charAt(i)) - Character.getNumericValue(value.charAt(i));
            if(s>=10)
                sum = s%10 + sum;
            else
                sum= s + sum;
            s/=10;
        }
        this.value = sum;
        return sum;
    }

    public String div(String value){
        for(int i=9;i>0;i--){
            BigInt bigInt1=new BigInt(value);
           String s= bigInt1.cross(String.valueOf(i));
           BigInt bigInt=new BigInt(s);
            if(bigInt.Comparison(this.value) == -1 ||bigInt.Comparison(this.value) == 0){
                this.value = String.valueOf(i);
                return String.valueOf(i);
            }
        }
        return "0";

    }

    public int Comparison(String value){
        for(int i=0;i<value.length();i++){
            if(Character.getNumericValue(this.value.charAt(i)) < Character.getNumericValue(value.charAt(i)))
                return 1;
            if(Character.getNumericValue(this.value.charAt(i)) > Character.getNumericValue(value.charAt(i))){
                return -1;
            }
        }
        return 0;
    }

    public int Comparison(int values){
        String value=String.valueOf(values);
        for(int i=0;i<value.length();i++){
            if(Character.getNumericValue(this.value.charAt(i)) < Character.getNumericValue(value.charAt(i)))
                return 1;
            if(Character.getNumericValue(this.value.charAt(i)) > Character.getNumericValue(value.charAt(i))){
                return -1;
            }
        }
        return 0;
    }
}
