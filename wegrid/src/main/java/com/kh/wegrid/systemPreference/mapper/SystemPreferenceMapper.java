package com.kh.wegrid.systemPreference.mapper;

import com.kh.wegrid.crm.vo.ClientRankVo;
import com.kh.wegrid.systemManager.vo.DepartMentVo;
import com.kh.wegrid.systemManager.vo.JobInfoVo;
import com.kh.wegrid.trip.vo.typeVo;
import com.kh.wegrid.vacation.vo.VacationTypeVo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SystemPreferenceMapper {
    //////////////////////////////// 정보 조회 ////////////////////////////////
    // 고객사 등급 정보 조회
    @Select("""
            SELECT
                NO
                , NAME
            FROM CLIENT_RANK
            ORDER BY NO
            """)
    List<ClientRankVo> getClientRankList();
    @Select("""
            SELECT
                NO
                , NAME
            FROM CLIENT_RANK
            WHERE NO = (SELECT (LAST_NUMBER-1) FROM USER_SEQUENCES WHERE SEQUENCE_NAME = 'SEQ_CLIENT_RANK')
            """)
    ClientRankVo getClientRankByNo();

    // 출장 유형 정보 조회
    @Select("""
            SELECT
                NO
                , NAME
            FROM TRIP_TYPE
            ORDER BY NO
            """)
    List<typeVo> getTripTypeList();
    @Select("""
            SELECT
                NO
                , NAME
            FROM TRIP_TYPE
            WHERE NO = (SELECT (LAST_NUMBER-1) FROM USER_SEQUENCES WHERE SEQUENCE_NAME = 'SEQ_TRIP_TYPE')
            """)
    typeVo getTripTypeByNo();

    // 부서 목록 조회
    @Select("""
            SELECT
                CODE
                , PARENT_CODE
                , HEAD_NO
                , NAME
                , DEL_YN
            FROM DEPARTMENT
            """)
    List<DepartMentVo> getDepartMentList();
    @Select("""
            SELECT
                CODE
                , NAME
            FROM DEPARTMENT
            WHERE CODE = #{code} 
            """)
    DepartMentVo getDepartmentByCode(String code);

    // 직급 목록, 직급 별 연차 수량 조회
    @Select("""
            SELECT
                NO
                , NAME
                , VAC_CNT
            FROM JOB_INFO
            ORDER BY NO
            """)
    List<JobInfoVo> getJobInfoList();
    @Select("""
            SELECT
                NO
                , NAME
                , VAC_CNT
            FROM JOB_INFO
            WHERE NO = (SELECT (LAST_NUMBER-1) FROM USER_SEQUENCES WHERE SEQUENCE_NAME = 'SEQ_JOB_INFO')
            """)
    JobInfoVo getJobInfoByNo();

    // 휴가 유형 정보 조회
    @Select("""
            SELECT
                NO
                , NAME
            FROM VACATION_TYPE
            ORDER BY NO
            """)
    List<VacationTypeVo> getVacationTypeList();
    @Select("""
            SELECT
                NO
                , NAME
            FROM VACATION_TYPE
            WHERE NO = (SELECT (LAST_NUMBER-1) FROM USER_SEQUENCES WHERE SEQUENCE_NAME = 'SEQ_VACATION_TYPE')
            """)
    VacationTypeVo getVacationByNo();


    //////////////////////////////// 정보 추가 ////////////////////////////////
    // 고객사 등급 추가
    @Insert("""
            INSERT INTO CLIENT_RANK
            (
                NO
                , NAME
            )
            VALUES
            (
                SEQ_CLIENT_RANK.NEXTVAL
                , #{name}
            )
            """)
    int addClientRank(String name);

    // 출장 항목 추가
    @Insert("""
            INSERT INTO TRIP_TYPE
            (
                NO
                , NAME
            )
            VALUES
            (
                SEQ_TRIP_TYPE.NEXTVAL
                , #{name}
            )
            """)
    int addTripType(String name);

    // 부서 추가
    @Insert("""
            INSERT INTO DEPARTMENT
            (
                CODE
                , NAME
            )
            VALUES
            (
                #{code}
                , #{name}
            )
            """)
    int addDepartment(String name, String code);

    // 직급 추가
    @Insert("""
            INSERT INTO JOB_INFO
            (
                NO
                , NAME
                , VAC_CNT
            )
            VALUES
            (
                SEQ_JOB_INFO.NEXTVAL
                , #{name}
                , #{vacCnt}
            )
            """)
    int addJobInfo(String name, int vacCnt);

    // 휴가 항목 추가
    @Insert("""
            INSERT INTO VACATION_TYPE
            (
                NO
                , NAME
            )
            VALUES
            (
                SEQ_VACATION_TYPE.NEXTVAL
                , #{name}
            )
            """)
    int addVacationType(String name);

    //////////////////////////////// 정보 수정 ////////////////////////////////
    // 고객사 등급명 수정
    @Update("""
            UPDATE CLIENT_RANK
            SET
                NAME = #{name}
            WHERE NO = #{no}
            """)
    int editClientRank(String no, String name);

    // 출장 항목명 수정
    @Update("""
            UPDATE TRIP_TYPE
            SET
                NAME = #{name}
            WHERE NO = #{no}
            """)
    int editTripType(String no, String name);

    // 부서명 수정
    @Update("""
            UPDATE DEPARTMENT
            SET
                NAME = #{name}
            WHERE CODE = #{code}
            AND DEL_YN = 'N'
            """)
    int editDepartment(String code, String name);

    // 직급명 수정
    @Update("""
            UPDATE JOB_INFO
            SET
                NAME = #{name}
            WHERE NO = #{no}
            """)
    int editJobInfo(String no, String name);

    // 휴가 항목명 수정
    @Update("""
            UPDATE VACATION_TYPE
            SET
                NAME = #{name}
            WHERE NO = #{no}
            """)
    int editVacationType(String no, String name);

    // 직급 별 연차 수량 수정
    @Update("""
            UPDATE JOB_INFO
            SET
                VAC_CNT = #{vacCnt}
            WHERE NO = #{no}
            """)
    int editVacationCnt(String no, int vacCnt);

    //////////////////////////////// 정보 삭제 ////////////////////////////////

    // 고객사 등급 삭제
    @Delete("""
            DELETE FROM CLIENT_RANK
            WHERE NO = #{no}
            """)
    int deleteClientRank(String no);

    // 출장 항목 삭제
    @Delete("""
            DELETE FROM TRIP_TYPE
            WHERE NO = #{no}
            """)
    int deleteTripType(String no);

    // 부서 삭제
    @Update("""
            UPDATE DEPARTMENT
            SET
                DEL_YN = 'Y'
            WHERE CODE = #{code}
            """)
    int deleteDepartment(String code);

    // 직급 삭제
    @Delete("""
            DELETE FROM JOB_INFO
            WHERE NO = #{no}
            """)
    int deleteJobInfo(String no);

    // 휴가 항목 삭제
    @Delete("""
            DELETE FROM VACATION_TYPE
            WHERE NO = #{no}
            """)
    int deleteVacationType(String no);

}//Interface
