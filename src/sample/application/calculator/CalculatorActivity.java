package sample.application.calculator;

//import sample.application.memopad.R;
import java.math.BigDecimal;
import java.text.DecimalFormat;

import android.os.Bundle;
import android.app.Activity;
import android.content.SharedPreferences;
import android.text.ClipboardManager;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Vibrator;
import android.content.SharedPreferences;

public class CalculatorActivity extends Activity {	// これ以降のthisはCalculatorActivity型のインスタンス変数である。
	
    public String num11 = new String();
    public String strTemp = "";
    public Integer oprator = 0;
    public String strResult;
    
//  public String hoge = this.strTemp;			// thisは使える。このときのthisはインスタンス変数である。
//  public String hoge = this.foo;				// thisは使える。このときのthisはインスタンス変数である。
//    　　　　　　　左辺値　　右辺値
//  public static String hog = this.strTemp;	// thisは使えない。
//	public static void onCre() {
//  　　hog = this.strTemp;							// thisは使えない。
//	}
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        readPreferences();
    }

    @Override
    protected void onStop() {
    	super.onStop();
    	writePreferences();
    }
    
    
//    public void numKeyOnClick(View v) {
////    	v.getText();
//    	Button button = (Button)v;
//    	Log.d("[button��text]", button.getText().toString());
//    	TextView tv = (TextView) this.findViewById(R.id.displayPanel);	// ��͂���Ƃ���B�����p�b�h�̂Ƃ��Ɠ���
//    	Log.d("[tv�̃C���X�^���X���m�F]", "tv.text: " + tv.getText().toString());
//    	tv.setText(tv.getText());	// �����{�^���������ƁAdisplayPanel�ɕ\�������B
//    	tv.setText((String)tv.getText() + button.getText().toString());
//    }
//    
//    public void test() {
//    	Button button = new Button(null);
//    	//	View butto = new View(null);
//    	this.numKeyOnClick(button);
//    }
//    public void addKeyOnClick(View v) {
//    	Log.d("[addkey���Ă΂ꂽ���m�F]","�Ă���");
//    	// String num1 = null;	// �\������Ă��鐔���̕ۑ��̈�Anum �� String�^�̃C���X�^���X�����ϐ�
//    	TextView tv = (TextView) this.findViewById(R.id.displayPanel);			// ���ӂ�tv ���@�C���X�^���X�̃A�h���X
//    	Log.d("[tv�̃C���X�^���X���m�F]","tv.text: " + tv.getText().toString());		// �E�ӂ�tv.�͑���
//    	Log.d("addkey����΂�Ă���",this.num1);
//    	this.num1 = tv.getText().toString();	// this ��Calculator activity�^�@���\�b�h�̂Ȃ��ŎQ�Ƃ���邽�߂�this�B
//    	Log.d("num1�ɃA�h���X���ꂽ����",this.num1);
//    	// num1 = tv.getText().toString();
//    	tv.setText("0");
//    }
    
    public void numKeyOnClick(View v){
    	((Vibrator)getSystemService(VIBRATOR_SERVICE)).vibrate(50);
    	String strInKey = (String) ((Button)v).getText();	//     	String strInKey = (String) ((Button)v).getText().string;  	

    	if(strInKey.equals(".")){
    		if(this.strTemp.length()==0){
    			this.strTemp="0.";
    		}else{
    			if(this.strTemp.indexOf(".")==-1){
    				this.strTemp = this.strTemp + ".";
    			}
    		}
    	}else{
    		this.strTemp = this.strTemp + strInKey;
    	}
    	//TODO インスタンス変数渡しとるわ
    	this.showNumber(this.strTemp);							// 文頭のthisは何インスタンスか？
    															//  → CalculatorActivity型の変数である。
    															//  → CalculatorActivity型のインスタンス
    															// 変数にはどんな制限がある？
    															//  → 型の指定がある。
    															//  → アドレスが入る。
    															// thisはインスタンスメソッド内で使われる。
    }
    
    public void showNumber(String strNum){						// p.111 リスト4
    	
    	DecimalFormat form = new DecimalFormat("#,##0");
    	String strDecimal = "";
    	String strInt = "";
    	String fText = "";
    	
    	if(strNum.length()>0){
    		int decimalPoint = strNum.indexOf(".");
    		if(decimalPoint>-1){
    			strDecimal = strNum.substring(decimalPoint);
    			strInt = strNum.substring(0,decimalPoint);
    			
    		}else{
    			strInt = strNum;
    		}
    		fText = form.format(Double.parseDouble(strInt)) + strDecimal;
    		
    	}else{ 					// { を付けた方がいい。
    							//
    		fText = "0";	 	//
    							//
    	}						// } を付けた方がいい。
    		
    							///////	以下のやり方ではまずい。	///////////////////////////////////////////////////
    							//
    							// }else
    							//		fText = "0";			// ぶら下がり構文
    							//      String hoge = "hoge";	// こっちはぶら下がってない。else fTextが終わってから読まれる。
    							//
    							///////////////////////////////////////////////////////////////////////////////


    	((TextView)findViewById(R.id.displayPanel)).setText(fText);
    	}
    
    
    public void equalKeyOnClick(View v){
    	Log.d("[equalKeyOnClick���Ă΂ꂽ���m�F]","�Ă���");
    	
    	// 新しく表示された数字を取得
    	// num1�ɕۑ������ŏ��̐������擾
    	// ���𑫂��B
    }
    
    public String num1 = new String(); 	// new String(); ���@String�I�u�W�F�N�g�̐���
//    
//    public void addKeyonClick(View v) {
//    	TextView tv = (TextView) this.findViewById(R.id.displayPanel);
//    	
//    public void addKeyonClick(View v) {
//    	TextView tView = (TextView)this.findViewById(R.id.displayPanel);
//    	this.sum = (Intefer.valueOf(tView.getText()) + Integer.valueOf();
//    	tView.setText(sum.toString());
//        }
    
    public void functionKeyOnClick(View v) {
    	((Vibrator)getSystemService(VIBRATOR_SERVICE)).vibrate(50);
    	switch(v.getId()) {
    	case R.id.keypadAC:
    		strTemp = "";
    		strResult = "0";
    		operator = 0;
    		break;
    	case R.id.keypadC:
    		strTemp = "";
    		break;
    	case R.id.keypadBS:
    		if(strTemp.length() == 0) return;
    		else strTemp = strTemp.substring(0, strTemp.length() -1);
    		break;
    	case R.id.keypadCopy:
    		ClipboardManager cm = (ClipboardManager) getSystemService(
    				CLIPBOARD_SERVICE);
    		cm.setText(((TextView)findViewById(R.id.displayPanel)).getText());
    		return;
    	}
    	showNumber(strTemp);
    }
    
    public void operatorKeyOnClick(View v){						// p.113 リスト6
    	((Vibrator)getSystemService(VIBRATOR_SERVICE)).vibrate(50);
    	
    	if(operator!= 0){
    		if(strTemp.length() > 0){
    			strResult = doCalc();
    			showNumber(strResult);
    		}
    	}
    	else{
    		if(strTemp.length() > 0){
    			strResult = strTemp;
    		}
    	}
    	strTemp = "";
    	
    	if(v.getId() == R.id.keypadEq){
    		operator = 0;
    	}else{
    		operator = v.getId();
    	}
    }
    
    private String doCalc(){
    	BigDecimal bd1 = new BigDecimal(strResult);
    	BigDecimal bd2 = new BigDecimal(strTemp);
    	BigDecimal result = BigDecimal.ZERO;				// BigDecimal型に定義されている変数ZERO
    	
    	swich(operator){
    	case R.id.keypadAdd:
			result = bd1.add(bd2);
			break;
    	case R.id.keypadSub:
			result = bd1.subtract(bd2);
			break;
    	case R.id.keypadMulti:
			result = bd1.multiply(bd2);
			break;
    	case R.id.keypadDiv:
    		if(!bd2.equals(BigDecimal.ZERO)){
    			result = bd1.divide(bd2, 12, 3);
    		}else{
    			Toast toast = Toast.makeText(this, R.string.toast_div_by_zero, 1000);
    			toast.show();
    		}
    		break;
    	}
    	
    	if(result.toString().indexOf(".") >= 0){
    		return result.toString().replaceAll("¥¥.0+$|0+$", "");
    	}else{
    		return result.toString();
    	}
    	
    }
    
    void writePreferences() {
    	SharedPreferences prefs = getSharedPreferences("CalcPrefs", MODE_PRIVATE);
    	SharedPreferences.Editor editor = prefs.edit();
    	editor.putString("strTemp", strTemp);
    	editor.putString("strResult", strResult);
    	editor.putInt("operator", operator);
    	editor.putString("strDisplay",
    			((TextView)findViewById(R.id.displayPanel)).getText().toString();
    	editor.commit();
    }
    
    void readPreferences() {
    	SharedPreferences prefs = getSharedPreferences("Calcprefs", MODE_PRIVATE);
    	strTemp = prefs.getString("strTemp", "");
    	strResult = prefs.getString("strResult", "0");
    	operator = prefs.getInt("operator", 0);
    	((TextView)findViewById(R.id.displayPanel)).setText(
    			prefs.getString("strDisplay", "0"));
    }
}
// テスト
// テスト
    	