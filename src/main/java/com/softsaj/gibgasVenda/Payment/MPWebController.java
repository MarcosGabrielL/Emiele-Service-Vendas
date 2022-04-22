package com.softsaj.gibgasVenda.Payment;

import com.mercadopago.exceptions.MPException;
import java.net.URI;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

/**
 *
 * @author Marcos
 */

@Controller
public class MPWebController {

    @GetMapping("/generic")
    public ResponseEntity<Void> success(
            HttpServletRequest request,
            @RequestParam("collection_id") String collectionId,
            @RequestParam("collection_status") String collectionStatus,
            @RequestParam("external_reference") String externalReference,
            @RequestParam("payment_type") String paymentType,
            @RequestParam("merchant_order_id") String merchantOrderId,
            @RequestParam("preference_id") String preferenceId,
            @RequestParam("site_id") String siteId,
            @RequestParam("processing_mode") String processingMode,
            @RequestParam("merchant_account_id") String merchantAccountId,
            RedirectAttributes attributes)
            throws MPException {
        
        //System.out.println(request + "-"+collectionId+"-"+collectionStatus);
        
        //SalvaDados de Pagamento

        return ResponseEntity.status(HttpStatus.FOUND).location(URI.create("https://emiele.herokuapp.com/cadastrar/payment/cart")).build();
 
    }   
}
