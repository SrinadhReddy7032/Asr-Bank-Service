package com.example.asrbank.controller;

import com.example.asrbank.model.LoanRequest;
import com.example.asrbank.service.AadhaarService;
import com.example.asrbank.service.PanService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/loan")
public class LoanController {

    private final AadhaarService aadhaarService;
    private final PanService panService;

    public LoanController(AadhaarService aadhaarService, PanService panService) {
        this.aadhaarService = aadhaarService;
        this.panService = panService;

    }

    @PostMapping("/verify")
    public ResponseEntity<String> applyLoan(@RequestBody LoanRequest request) {
        String aadhaarResult = aadhaarService.verifyAadhaar(request.getAadhaar());
        String panResult = panService.verifyPan(request.getPan());
        String cibil = panResult.substring(panResult.length()-3);
        if(panResult.length()>17&&aadhaarResult.length()>17) {
	        if(Integer.valueOf(cibil)>500)
	        {
	        	return ResponseEntity.ok("Loan check complete:\n"
	                    + "Aadhaar: " + aadhaarResult + "\n"
	                    + "PAN: " + panResult +"\n"+ "Status:" + "Accepted" );
	        }
        }
        return ResponseEntity.ok("Loan check complete:\n"
                + "Aadhaar: " + aadhaarResult + "\n"
                + "PAN: " + panResult +"\n"+ "Status:" + "Not Accepted" );
    }
}