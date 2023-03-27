package com.goal.merchantsimulator.service;

import com.goal.merchantsimulator.config.Constant;
import com.goal.merchantsimulator.dto.TerminalMapper;
import com.goal.merchantsimulator.dto.inbound.TerminalRequest;
import com.goal.merchantsimulator.dto.outbound.AdminGeneralResponse;
import com.goal.merchantsimulator.model.Terminal;
import com.goal.merchantsimulator.repository.TerminalRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TerminalService {

    private final TerminalRepo terminalRepo;

    public AdminGeneralResponse save(TerminalRequest terminalRequest){
        Optional<Terminal> applicationOptional = terminalRepo.findByClientId(terminalRequest.getClientId());
        if (applicationOptional.isEmpty()){
            return new AdminGeneralResponse(Constant.ResponseCode.Success.code,Constant.ResponseCode.Success.msg,terminalRepo.save(TerminalMapper.toMapper(terminalRequest)));
        }
        return new AdminGeneralResponse(-1,"Application already exists",null);
    }

    public AdminGeneralResponse delete(Long id){
        Optional<Terminal> terminalOptional = terminalRepo.findById(id);
        if (terminalOptional.isPresent()){
            terminalRepo.delete(terminalOptional.get());
            return new AdminGeneralResponse(Constant.ResponseCode.Success.code,Constant.ResponseCode.Success.msg,null);
        }
        return new AdminGeneralResponse(-2,"Application not found",null);
    }

    public AdminGeneralResponse update(TerminalRequest applicationRequest, Long id){
        Optional<Terminal> terminalOptional = terminalRepo.findById(id);
        if (terminalOptional.isPresent()){
            Terminal terminal = terminalOptional.get();
            terminal.setClientId(applicationRequest.getClientId()).setNotes(applicationRequest.getNotes());
            return new AdminGeneralResponse(Constant.ResponseCode.Success.code,Constant.ResponseCode.Success.msg,terminalRepo.save(terminal));
        }
        return new AdminGeneralResponse(-2,"Application not found",null);

    }

    public AdminGeneralResponse getTerminal(Long id){
        return new AdminGeneralResponse(Constant.ResponseCode.Success.code,Constant.ResponseCode.Success.msg,terminalRepo.findById(id));
    }

    public AdminGeneralResponse getTerminals(){
        return new AdminGeneralResponse(Constant.ResponseCode.Success.code,Constant.ResponseCode.Success.msg,terminalRepo.findAll());
    }
}
