package com.example.pallavinishanth.gemrtest;

/**
 * Created by pallavinishanth on 1/19/18.
 */
import retrofit2.Call;
import retrofit2.http.GET;

public interface ClubRetrofit {

    @GET("/groups?appId=d7fddddfe7076bdca78836365c8ace12&fields%5Bclubs%5D=id,vid,nameSlug,name,images,members,numberItems,numberItemsFiltered,numberSaleItemsFiltered,numberAffiliatesFiltered,numberCollections,numberCollectionsFiltered,numberMembers,moderatorUserIds,moderatorInfo,createdByUserId,createdBy,categories,type,inactiveClub,isPublic,membersOnly,isPrivate,frozen,brand&fields%5BmoderatorInfo%5D=id,username,profileImage,type ")
    Call<ClubList> CLUB_LIST_CALL();
}
