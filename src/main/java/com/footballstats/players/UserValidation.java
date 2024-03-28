
package com.footballstats.players;

import com.footballstats.players.dto.ResponseDTO;
import com.footballstats.players.model.User;


public class UserValidation {
    
    public ResponseDTO validate(User user) {
        
        ResponseDTO response = new ResponseDTO();
        response.setNumOfErrors(0);
        
        if (user.getUsername() == null) {
            response.setNumOfErrors(response.getNumOfErrors() + 1);
            response.setMessage("El campo username no puede ser nulo");
        }

        return response;
    }
}
