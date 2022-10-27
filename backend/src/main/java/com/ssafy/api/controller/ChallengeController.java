package com.ssafy.api.controller;


import com.ssafy.api.service.ChallengeService;
import com.ssafy.common.model.response.BaseResponseBody;
import com.ssafy.db.entity.Challenge;
import io.swagger.annotations.*;
import com.ssafy.api.request.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(value = "Challenge API", tags = {"Challenges"})
@RestController
@RequestMapping("/api/challenge")
public class ChallengeController {

    @Autowired
    ChallengeService challengeService;

    @PostMapping()
    @ApiOperation(value = "챌린지 생성", notes = "<strong>챌린지 정보를 입력하여</strong> 챌린지를 만든다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 401, message = "권한 없음"),
            @ApiResponse(code = 404, message = "해당하는 챌린지 없음"),
            @ApiResponse(code = 500, message = "서버 오류")
    })

    public ResponseEntity<? extends BaseResponseBody> createChallenge
            (@RequestBody @ApiParam(value = "챌린지") ChallengePostReq challengePostReq) {

        challengeService.createChllenge(challengePostReq);

        return ResponseEntity.status(200).body(BaseResponseBody.of(200,"Sucess"));
    }


}
