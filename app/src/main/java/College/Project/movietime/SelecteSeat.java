package College.Project.movietime;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import College.Project.movietime.databinding.ActivityMainBinding;
import College.Project.movietime.databinding.ActivitySelecteSeatBinding;

public class SelecteSeat extends AppCompatActivity {
    private ActivitySelecteSeatBinding binding;
    private int NoOfTickets;
    int noOfSeatsSelected=0;
    String SeatNos="";
    String TotalAmount="0";
    List<String> AllSeatIdsGlobal=new ArrayList<String>(Arrays.asList(
            "A1","A2","A3","A4","A5","A6","A7","A8","A9","A10","A11","A12"
            ,"B1","B2","B3","B4","B5","B6","B7","B8","B9","B10","B11","B12",
            "C1","C2","C3","C4","C5","C6","C7","C8","C9","C10","C11","C12",
            "D1","D2","D3","D4","D5","D6","D7","D8","D9","D10","D11","D12",
            "E1","E2","E3","E4","E5","E6","E7","E8","E9","E10","E11","E12",
            "F1","F2","F3","F4","F5","F6","F7","F8","F9","F10","F11","F12",
            "G1","G2","G3","G4","G5","G6","G7","G8","G9","G10","G11","G12",
            "H1","H2","H3","H4","H5","H6","H7","H8","H9","H10","H11","H12",
            "I1","I2","I3","I4","I5","I6","I7","I8","I9","I10","I11","I12",
            "J1","J2","J3","J4","J5","J6","J7","J8","J9","J10","J11","J12"
            ,"K1","K2","K3","K4","K5","K6","K7","K8","K9","K10","K11","K12"
    ));
    List<String>selectedSeatIds=new ArrayList<String>();
    List<String> AlreadySeatBooked ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding=ActivitySelecteSeatBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
        NoOfTickets=3;

        GetSeatNoRequest();
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it =new Intent(getApplicationContext(),PrintTicket.class);
                startActivity(it);
            }
        });
        //check change Listner for A row  ------------------------------
       binding.A1.setOnCheckedChangeListener(new SelecteSeat.myOnCheckChangeEvent());
        binding.A2.setOnCheckedChangeListener(new SelecteSeat.myOnCheckChangeEvent());
        binding.A3.setOnCheckedChangeListener(new SelecteSeat.myOnCheckChangeEvent());
        binding.A4.setOnCheckedChangeListener(new SelecteSeat.myOnCheckChangeEvent());
        binding.A5.setOnCheckedChangeListener(new SelecteSeat.myOnCheckChangeEvent());
        binding.A6.setOnCheckedChangeListener(new SelecteSeat.myOnCheckChangeEvent());
        binding.A7.setOnCheckedChangeListener(new SelecteSeat.myOnCheckChangeEvent());
        binding.A8.setOnCheckedChangeListener(new SelecteSeat.myOnCheckChangeEvent());
        binding.A9.setOnCheckedChangeListener(new SelecteSeat.myOnCheckChangeEvent());
        binding.A10.setOnCheckedChangeListener(new SelecteSeat.myOnCheckChangeEvent());
        binding.A11.setOnCheckedChangeListener(new SelecteSeat.myOnCheckChangeEvent());
        binding.A12.setOnCheckedChangeListener(new SelecteSeat.myOnCheckChangeEvent());
        //check change Listner for A row Ends ------------------------------
        //check change Listner for B row  ------------------------------
        binding.B1.setOnCheckedChangeListener(new SelecteSeat.myOnCheckChangeEvent());
        binding.B2.setOnCheckedChangeListener(new SelecteSeat.myOnCheckChangeEvent());
        binding.B3.setOnCheckedChangeListener(new SelecteSeat.myOnCheckChangeEvent());
        binding.B4.setOnCheckedChangeListener(new SelecteSeat.myOnCheckChangeEvent());
        binding.B5.setOnCheckedChangeListener(new SelecteSeat.myOnCheckChangeEvent());
        binding.B6.setOnCheckedChangeListener(new SelecteSeat.myOnCheckChangeEvent());
        binding.B7.setOnCheckedChangeListener(new SelecteSeat.myOnCheckChangeEvent());
        binding.B8.setOnCheckedChangeListener(new SelecteSeat.myOnCheckChangeEvent());
        binding.B9.setOnCheckedChangeListener(new SelecteSeat.myOnCheckChangeEvent());
        binding.B10.setOnCheckedChangeListener(new SelecteSeat.myOnCheckChangeEvent());
        binding.B11.setOnCheckedChangeListener(new SelecteSeat.myOnCheckChangeEvent());
        binding.B12.setOnCheckedChangeListener(new SelecteSeat.myOnCheckChangeEvent());
        //check change Listner for B row Ends ------------------------------
        //check change Listner for C row  ------------------------------
        binding.C1.setOnCheckedChangeListener(new SelecteSeat.myOnCheckChangeEvent());
        binding.C2.setOnCheckedChangeListener(new SelecteSeat.myOnCheckChangeEvent());
        binding.C3.setOnCheckedChangeListener(new SelecteSeat.myOnCheckChangeEvent());
        binding.C4.setOnCheckedChangeListener(new SelecteSeat.myOnCheckChangeEvent());
        binding.C5.setOnCheckedChangeListener(new SelecteSeat.myOnCheckChangeEvent());
        binding.C6.setOnCheckedChangeListener(new SelecteSeat.myOnCheckChangeEvent());
        binding.C7.setOnCheckedChangeListener(new SelecteSeat.myOnCheckChangeEvent());
        binding.C8.setOnCheckedChangeListener(new SelecteSeat.myOnCheckChangeEvent());
        binding.C9.setOnCheckedChangeListener(new SelecteSeat.myOnCheckChangeEvent());
        binding.C10.setOnCheckedChangeListener(new SelecteSeat.myOnCheckChangeEvent());
        binding.C11.setOnCheckedChangeListener(new SelecteSeat.myOnCheckChangeEvent());
        binding.C12.setOnCheckedChangeListener(new SelecteSeat.myOnCheckChangeEvent());
        //check change Listner for C row Ends ------------------------------
        //check change Listner for D row  ------------------------------
        binding.D1.setOnCheckedChangeListener(new SelecteSeat.myOnCheckChangeEvent());
        binding.D2.setOnCheckedChangeListener(new SelecteSeat.myOnCheckChangeEvent());
        binding.D3.setOnCheckedChangeListener(new SelecteSeat.myOnCheckChangeEvent());
        binding.D4.setOnCheckedChangeListener(new SelecteSeat.myOnCheckChangeEvent());
        binding.D5.setOnCheckedChangeListener(new SelecteSeat.myOnCheckChangeEvent());
        binding.D6.setOnCheckedChangeListener(new SelecteSeat.myOnCheckChangeEvent());
        binding.D7.setOnCheckedChangeListener(new SelecteSeat.myOnCheckChangeEvent());
        binding.D8.setOnCheckedChangeListener(new SelecteSeat.myOnCheckChangeEvent());
        binding.D9.setOnCheckedChangeListener(new SelecteSeat.myOnCheckChangeEvent());
        binding.D10.setOnCheckedChangeListener(new SelecteSeat.myOnCheckChangeEvent());
        binding.D11.setOnCheckedChangeListener(new SelecteSeat.myOnCheckChangeEvent());
        binding.D12.setOnCheckedChangeListener(new SelecteSeat.myOnCheckChangeEvent());
        //check change Listner for D row Ends ------------------------------
        //check change Listner for E row  ------------------------------
        binding.E1.setOnCheckedChangeListener(new SelecteSeat.myOnCheckChangeEvent());
        binding.E2.setOnCheckedChangeListener(new SelecteSeat.myOnCheckChangeEvent());
        binding.E3.setOnCheckedChangeListener(new SelecteSeat.myOnCheckChangeEvent());
        binding.E4.setOnCheckedChangeListener(new SelecteSeat.myOnCheckChangeEvent());
        binding.E5.setOnCheckedChangeListener(new SelecteSeat.myOnCheckChangeEvent());
        binding.E6.setOnCheckedChangeListener(new SelecteSeat.myOnCheckChangeEvent());
        binding.E7.setOnCheckedChangeListener(new SelecteSeat.myOnCheckChangeEvent());
        binding.E8.setOnCheckedChangeListener(new SelecteSeat.myOnCheckChangeEvent());
        binding.E9.setOnCheckedChangeListener(new SelecteSeat.myOnCheckChangeEvent());
        binding.E10.setOnCheckedChangeListener(new SelecteSeat.myOnCheckChangeEvent());
        binding.E11.setOnCheckedChangeListener(new SelecteSeat.myOnCheckChangeEvent());
        binding.E12.setOnCheckedChangeListener(new SelecteSeat.myOnCheckChangeEvent());
        //check change Listner for E row Ends ------------------------------
        //check change Listner for F row  ------------------------------
        binding.F1.setOnCheckedChangeListener(new SelecteSeat.myOnCheckChangeEvent());
        binding.F2.setOnCheckedChangeListener(new SelecteSeat.myOnCheckChangeEvent());
        binding.F3.setOnCheckedChangeListener(new SelecteSeat.myOnCheckChangeEvent());
        binding.F4.setOnCheckedChangeListener(new SelecteSeat.myOnCheckChangeEvent());
        binding.F5.setOnCheckedChangeListener(new SelecteSeat.myOnCheckChangeEvent());
        binding.F6.setOnCheckedChangeListener(new SelecteSeat.myOnCheckChangeEvent());
        binding.F7.setOnCheckedChangeListener(new SelecteSeat.myOnCheckChangeEvent());
        binding.F8.setOnCheckedChangeListener(new SelecteSeat.myOnCheckChangeEvent());
        binding.F9.setOnCheckedChangeListener(new SelecteSeat.myOnCheckChangeEvent());
        binding.F10.setOnCheckedChangeListener(new SelecteSeat.myOnCheckChangeEvent());
        binding.F11.setOnCheckedChangeListener(new SelecteSeat.myOnCheckChangeEvent());
        binding.F12.setOnCheckedChangeListener(new SelecteSeat.myOnCheckChangeEvent());
        //check change Listner for F row Ends ------------------------------
        //check change Listner for G row  ------------------------------
        binding.G1.setOnCheckedChangeListener(new SelecteSeat.myOnCheckChangeEvent());
        binding.G2.setOnCheckedChangeListener(new SelecteSeat.myOnCheckChangeEvent());
        binding.G3.setOnCheckedChangeListener(new SelecteSeat.myOnCheckChangeEvent());
        binding.G4.setOnCheckedChangeListener(new SelecteSeat.myOnCheckChangeEvent());
        binding.G5.setOnCheckedChangeListener(new SelecteSeat.myOnCheckChangeEvent());
        binding.G6.setOnCheckedChangeListener(new SelecteSeat.myOnCheckChangeEvent());
        binding.G7.setOnCheckedChangeListener(new SelecteSeat.myOnCheckChangeEvent());
        binding.G8.setOnCheckedChangeListener(new SelecteSeat.myOnCheckChangeEvent());
        binding.G9.setOnCheckedChangeListener(new SelecteSeat.myOnCheckChangeEvent());
        binding.G10.setOnCheckedChangeListener(new SelecteSeat.myOnCheckChangeEvent());
        binding.G11.setOnCheckedChangeListener(new SelecteSeat.myOnCheckChangeEvent());
        binding.G12.setOnCheckedChangeListener(new SelecteSeat.myOnCheckChangeEvent());
        //check change Listner for G row Ends ------------------------------
        //check change Listner for H row  ------------------------------
        binding.H1.setOnCheckedChangeListener(new SelecteSeat.myOnCheckChangeEvent());
        binding.H2.setOnCheckedChangeListener(new SelecteSeat.myOnCheckChangeEvent());
        binding.H3.setOnCheckedChangeListener(new SelecteSeat.myOnCheckChangeEvent());
        binding.H4.setOnCheckedChangeListener(new SelecteSeat.myOnCheckChangeEvent());
        binding.H5.setOnCheckedChangeListener(new SelecteSeat.myOnCheckChangeEvent());
        binding.H6.setOnCheckedChangeListener(new SelecteSeat.myOnCheckChangeEvent());
        binding.H7.setOnCheckedChangeListener(new SelecteSeat.myOnCheckChangeEvent());
        binding.H8.setOnCheckedChangeListener(new SelecteSeat.myOnCheckChangeEvent());
        binding.H9.setOnCheckedChangeListener(new SelecteSeat.myOnCheckChangeEvent());
        binding.H10.setOnCheckedChangeListener(new SelecteSeat.myOnCheckChangeEvent());
        binding.H11.setOnCheckedChangeListener(new SelecteSeat.myOnCheckChangeEvent());
        binding.H12.setOnCheckedChangeListener(new SelecteSeat.myOnCheckChangeEvent());
        //check change Listner for F row Ends ------------------------------
        //check change Listner for I row  ------------------------------
        binding.I1.setOnCheckedChangeListener(new SelecteSeat.myOnCheckChangeEvent());
        binding.I2.setOnCheckedChangeListener(new SelecteSeat.myOnCheckChangeEvent());
        binding.I3.setOnCheckedChangeListener(new SelecteSeat.myOnCheckChangeEvent());
        binding.I4.setOnCheckedChangeListener(new SelecteSeat.myOnCheckChangeEvent());
        binding.I5.setOnCheckedChangeListener(new SelecteSeat.myOnCheckChangeEvent());
        binding.I6.setOnCheckedChangeListener(new SelecteSeat.myOnCheckChangeEvent());
        binding.I7.setOnCheckedChangeListener(new SelecteSeat.myOnCheckChangeEvent());
        binding.I8.setOnCheckedChangeListener(new SelecteSeat.myOnCheckChangeEvent());
        binding.I9.setOnCheckedChangeListener(new SelecteSeat.myOnCheckChangeEvent());
        binding.I10.setOnCheckedChangeListener(new SelecteSeat.myOnCheckChangeEvent());
        binding.I11.setOnCheckedChangeListener(new SelecteSeat.myOnCheckChangeEvent());
        binding.I12.setOnCheckedChangeListener(new SelecteSeat.myOnCheckChangeEvent());
        //check change Listner for I row Ends ------------------------------
        //check change Listner for J row  ------------------------------
        binding.J1.setOnCheckedChangeListener(new SelecteSeat.myOnCheckChangeEvent());
        binding.J2.setOnCheckedChangeListener(new SelecteSeat.myOnCheckChangeEvent());
        binding.J3.setOnCheckedChangeListener(new SelecteSeat.myOnCheckChangeEvent());
        binding.J4.setOnCheckedChangeListener(new SelecteSeat.myOnCheckChangeEvent());
        binding.J5.setOnCheckedChangeListener(new SelecteSeat.myOnCheckChangeEvent());
        binding.J6.setOnCheckedChangeListener(new SelecteSeat.myOnCheckChangeEvent());
        binding.J7.setOnCheckedChangeListener(new SelecteSeat.myOnCheckChangeEvent());
        binding.J8.setOnCheckedChangeListener(new SelecteSeat.myOnCheckChangeEvent());
        binding.J9.setOnCheckedChangeListener(new SelecteSeat.myOnCheckChangeEvent());
        binding.J10.setOnCheckedChangeListener(new SelecteSeat.myOnCheckChangeEvent());
        binding.J11.setOnCheckedChangeListener(new SelecteSeat.myOnCheckChangeEvent());
        binding.J12.setOnCheckedChangeListener(new SelecteSeat.myOnCheckChangeEvent());
        //check change Listner for J row Ends ------------------------------
        //check change Listner for K row  ------------------------------
        binding.K1.setOnCheckedChangeListener(new SelecteSeat.myOnCheckChangeEvent());
        binding.K2.setOnCheckedChangeListener(new SelecteSeat.myOnCheckChangeEvent());
        binding.K3.setOnCheckedChangeListener(new SelecteSeat.myOnCheckChangeEvent());
        binding.K4.setOnCheckedChangeListener(new SelecteSeat.myOnCheckChangeEvent());
        binding.K5.setOnCheckedChangeListener(new SelecteSeat.myOnCheckChangeEvent());
        binding.K6.setOnCheckedChangeListener(new SelecteSeat.myOnCheckChangeEvent());
        binding.K7.setOnCheckedChangeListener(new SelecteSeat.myOnCheckChangeEvent());
        binding.K8.setOnCheckedChangeListener(new SelecteSeat.myOnCheckChangeEvent());
        binding.K9.setOnCheckedChangeListener(new SelecteSeat.myOnCheckChangeEvent());
        binding.K10.setOnCheckedChangeListener(new SelecteSeat.myOnCheckChangeEvent());
        binding.K11.setOnCheckedChangeListener(new SelecteSeat.myOnCheckChangeEvent());
        binding.K12.setOnCheckedChangeListener(new SelecteSeat.myOnCheckChangeEvent());
    }
    class myOnCheckChangeEvent implements CompoundButton.OnCheckedChangeListener{
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

            if(buttonView.isChecked()){
                String id=buttonView.getResources().getResourceName(buttonView.getId());
                id=id.replace("College.Project.movietime:id/","");
                noOfSeatsSelected++;
                int index=selectedSeatIds.indexOf(id);
                selectedSeatIds.add(id);
                IncreaseTheAmount(id);
                if(SeatNos.equals("")){
                    SeatNos=BuildMySeatNoString(id);
                }else{
                    SeatNos=SeatNos+"/"+BuildMySeatNoString(id);
                }
                binding.SeatNumbersSelected.setText(SeatNos);
                if(noOfSeatsSelected ==NoOfTickets){
                    DisableExceptSelectedSeat(selectedSeatIds,AlreadySeatBooked);
                }

            }if(!buttonView.isChecked()){
                String id=buttonView.getResources().getResourceName(buttonView.getId());
                id=id.replace("College.Project.movietime:id/","");
                noOfSeatsSelected--;
                selectedSeatIds.remove(id);
                String NewSeatNos=RemoveSeatIdsAfterDeselected(SeatNos,id);
                DecreaseTheAmount(id);
                SeatNos=NewSeatNos;
                binding.SeatNumbersSelected.setText(NewSeatNos);
                EnableSeatsAfterSeatGetsDeSelected(AlreadySeatBooked);
            }
        }
    }
    public void DisableBookedSeats(List<String> seatList){
        Enumeration<String> stBook= Collections.enumeration(seatList);
        CheckBox[] checkboxes=new CheckBox[seatList.size()];
        int i=0;
        while(stBook.hasMoreElements()){
            int resID = getResources().getIdentifier(stBook.nextElement(), "id", getPackageName());
            checkboxes[i]=(CheckBox) findViewById(resID);
            checkboxes[i].setEnabled(false);
            i++;
        }
        binding.HzViewSeat.setVisibility(View.VISIBLE);
    }
    public void DisableExceptSelectedSeat(List<String> SelectedSeatIds,List<String> AlreadyDisabledSeats){
        List<String>AllSeatIds=new ArrayList<>(AllSeatIdsGlobal);
        AllSeatIds.removeAll(SelectedSeatIds);
        AllSeatIds.removeAll(AlreadyDisabledSeats);
        Enumeration<String> EnumAllSeats=Collections.enumeration(AllSeatIds);
        CheckBox[] allCheckBoxes=new CheckBox [AllSeatIds.size()];
        int i=0;
        try{
            while(EnumAllSeats.hasMoreElements())
            {
                int resID = getResources().getIdentifier(EnumAllSeats.nextElement(), "id", getPackageName());
                allCheckBoxes[i]=(CheckBox) findViewById(resID);
                allCheckBoxes[i].setEnabled(false);
                i++;
            }
        }catch (Exception ex){
            Toast.makeText(this, "Error : "+ex+" "+i, Toast.LENGTH_LONG).show();
        }

    }
    public void EnableSeatsAfterSeatGetsDeSelected(List<String> AlreadyDisabledSeats){
        List<String>AllSeatIds=new ArrayList<>(AllSeatIdsGlobal);
        AllSeatIds.removeAll(AlreadyDisabledSeats);
        Enumeration<String> EnumAllSeats=Collections.enumeration(AllSeatIds);
        CheckBox[] allCheckBoxes=new CheckBox [AllSeatIds.size()];
        int i=0;
        try{
            while(EnumAllSeats.hasMoreElements())
            {
                int resID = getResources().getIdentifier(EnumAllSeats.nextElement(), "id", getPackageName());
                allCheckBoxes[i]=(CheckBox) findViewById(resID);
                allCheckBoxes[i].setEnabled(true);
                i++;
            }
        }catch (Exception ex){
            Toast.makeText(this, "Error : "+ex+" "+i, Toast.LENGTH_LONG).show();
        }
    }
    public void GetSeatNoRequest(){


        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        String url ="https://inundated-lenders.000webhostapp.com/Admin/php/GetBookedSeatsApiForAndroid.php?id=1";

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            List<String> mySeatsNos =new ArrayList<>();
                            JSONArray jsonArray=new JSONArray(response);
                            for(int i=0;i<jsonArray.length();i++){
                                JSONObject jsonObject =jsonArray.getJSONObject(i);
                                mySeatsNos.add(jsonObject.getString("SeatNo"));
                            }
                            setSeatValue(mySeatsNos);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Error",error.getLocalizedMessage());
            }
            protected Map<String, String> getParams(){
                Map<String, String> paramV = new HashMap<>();
                paramV.put("ShowId", "1");
                return paramV;
            }
        });

        queue.add(stringRequest);
        //return mySeatsNos;
    }
    List<String> BookedSeatsArrayList;
    public void setSeatValue(List<String> SeatNoList){
        BookedSeatsArrayList=new ArrayList<>(SeatNoList);
        AlreadySeatBooked=new ArrayList<String>(SeatNoList);
        DisableBookedSeats(AlreadySeatBooked);


    }
    public List<String> getSeatValues(){
        return this.BookedSeatsArrayList;
    }
    public String BuildMySeatNoString(String id){
        String SeatNoType=id+"("+GetSeatType(id)+")";
        return SeatNoType;
    }
    public String GetSeatType(String id){
        String SeatType="";
        if(id.contains("K") || id.contains("J")){
            SeatType="Platinum";
        }
        else if(id.contains("E") || id.contains("F") || id.contains("G")|| id.contains("H")|| id.contains("I")){
            SeatType="Gold";
        }else
        {
            SeatType="Silver";
        }
        return SeatType;
    }
    public String RemoveSeatIdsAfterDeselected(String SeatIds,String deselectedSeat){
        String SeatNoReturn = "";
        if(SeatIds.contains("/")) {
            String[] SeatArray = SeatIds.split("/");
            String SeatNoBuild = BuildMySeatNoString(deselectedSeat);
            List<String> SeatList = new ArrayList<>(Arrays.asList(SeatArray));
            SeatList.remove(SeatNoBuild);
            Enumeration<String> e = Collections.enumeration(SeatList);
            while (e.hasMoreElements()) {
                if (!SeatNoReturn.equals("")) {
                    SeatNoReturn = SeatNoReturn + "/" + e.nextElement();
                } else {
                    SeatNoReturn = e.nextElement();
                }
            }
        }else{
            SeatNoReturn="";
        }
        return SeatNoReturn;
    }
    public void IncreaseTheAmount(String id){
        String type=GetSeatType(id);
        String MyAmount=TotalAmount.replace("₹","");
        int Amount=Integer.parseInt(MyAmount);
        if(type.equals("Platinum")){
            Amount+=300;
        }else if(type.equals("Gold")){
            Amount+=200;
        }else{
            Amount+=150;
        }
        TotalAmount="₹"+Amount;
        binding.SeatSelectedTotalAmount.setText(TotalAmount);
    }
    public void DecreaseTheAmount(String id){
        String type=GetSeatType(id);
        String MyAmount=TotalAmount.replace("₹","");
        int Amount=Integer.parseInt(MyAmount);
        if(type.equals("Platinum")){
            Amount-=300;
        }else if(type.equals("Gold")){
            Amount-=200;
        }else{
            Amount-=150;
        }
        TotalAmount="₹"+Amount;
        binding.SeatSelectedTotalAmount.setText(TotalAmount);
    }
}