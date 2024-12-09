package com.kh.wegrid.conf;

import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class PathInfo {

    private final String staticPath = "D:" + File.separator
            + "SemiPrjTeam2" + File.separator
            + "wegrid" + File.separator
            + "src" + File.separator
            + "main" + File.separator
            + "resources" + File.separator
            + "static" + File.separator
            ;

//    public String getProfilePath(){
//        String path = staticPath
//                + "img" + File.separator
//                + "profile" + File.separator;
//        return path;
//
//    }

    public String getBoardAttachmentPath(){
        String path = staticPath
                + "file" + File.separator
                + "board" + File.separator
                + "attachment" + File.separator;
        return path;

    }

    public String getNoticeAttachmentPath(){
        String path = staticPath
                + "file" + File.separator
                + "notice" + File.separator
                + "attachment" + File.separator;
        return path;

    }

    public String getApprovalAttachmentPath(){
        String path = staticPath
                + "file" + File.separator
                + "approval" + File.separator
                + "attachment" + File.separator;
        return path;

    }
}
