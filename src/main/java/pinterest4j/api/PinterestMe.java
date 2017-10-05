/*
 * Copyright (c) 2017 Aniket Divekar
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package pinterest4j.api;

import pinterest4j.entity.Board;
import pinterest4j.entity.Interest;
import pinterest4j.entity.Pin;
import pinterest4j.entity.User;
import pinterest4j.util.exception.PinterestException;
import pinterest4j.util.list.PageResponseList;
import pinterest4j.util.list.ResponseList;

/**
 * Provides all the interfaces for Pinterest <b>Me</b> APIs
 *
 * Created by Aniket Divekar.
 */
public interface PinterestMe {

    /**
     *
     * Get Authenticated {@link User} with default fields
     * Default fields returned by Pinterest are:
     * <ul>
     *  <li>id</li>
     *  <li>first_name</li>
     *  <li>last_name</li>
     *  <li>url</li>
     * </ul>
     *
     * @return {@link User}
     * @throws PinterestException when Pinterest is unavailable or sends an error
     */
    User getMe() throws PinterestException;

    /**
     *
     * Get Authenticated {@link User} with specific fields
     * Possible fields that can be returned by Pinterest are:
     * <ul>
     *      <li>id</li>
     *      <li>first_name</li>
     *      <li>last_name</li>
     *      <li>url</li>
     *      <li>username</li>
     *      <li>account_type</li>
     *      <li>bio</li>
     *      <li>created_at</li>
     *      <li>image</li>
     *      <li>counts</li>
     * </ul>
     *
     * @param fields array of specific fields required to be queried from Pinterest
     *
     * @return {@link User}
     * @throws PinterestException when Pinterest is unavailable or sends an error
     */
    User getMe(String[] fields) throws PinterestException;

    /**
     *
     * Get Authenticated Users's Boards with default fields
     * Default fields returned by Pinterest are:
     * <ul>
     *  <li>id</li>
     *  <li>name</li>
     *  <li>url</li>
     * </ul>
     *
     * @return {@link ResponseList<Board>}
     * @throws PinterestException when Pinterest is unavailable or sends an error
     */
    ResponseList<Board> getMeBoards() throws PinterestException;

    /**
     *
     * Get Authenticated Users's Boards with specific fields
     * Possible fields that can be returned by Pinterest are:
     * <ul>
     *  <li>id</li>
     *  <li>name</li>
     *  <li>creator</li>
     *  <li>url</li>
     *  <li>created_at</li>
     *  <li>privacy</li>
     *  <li>image</li>
     *  <li>description</li>
     *  <li>counts</li>
     * </ul>
     *
     * <b>NOTE: <i>reason</i> field is planned to be included in future release</b>
     *
     * @param fields array of specific fields required to be queried from Pinterest
     *
     * @return {@link ResponseList<Board>}
     * @throws PinterestException when Pinterest is unavailable or sends an error
     */
    ResponseList<Board> getMeBoards(String[] fields) throws PinterestException;

    /**
     *
     * Get Authenticated User's suggested boards with default fields
     * Default fields returned by Pinterest are:
     * <ul>
     *  <li>id</li>
     *  <li>name</li>
     *  <li>url</li>
     * </ul>
     *
     * @return {@link ResponseList<Board>}
     * @throws PinterestException when Pinterest is unavailable or sends an error
     */
    ResponseList<Board> getMeSuggestedBoards(int count , String pin) throws PinterestException;

    /**
     *
     * Get Authenticated User's suggested boards with specific fields
     * Possible fields that can be returned by Pinterest are:
     * <ul>
     *  <li>id</li>
     *  <li>name</li>
     *  <li>creator</li>
     *  <li>url</li>
     *  <li>created_at</li>
     *  <li>privacy</li>
     *  <li>image</li>
     *  <li>description</li>
     *  <li>counts</li>
     * </ul>
     *
     * <b>NOTE: <i>reason</i> field is planned to be included in future release</b>
     *
     * @param fields array of specific fields required to be queried from Pinterest
     *
     * @return {@link ResponseList<Board>}
     * @throws PinterestException when Pinterest is unavailable or sends an error
     */
    ResponseList<Board> getMeSuggestedBoards(int count , String pin, String[] fields) throws PinterestException;

    /**
     *
     * get boards that the authenticated user follows
     *
     * @param cursor cursor from where boards are to be fetched
     *
     * @return {@link PageResponseList<Board>}
     *
     * @throws PinterestException when Pinterest is unavailable or sends an error
     */
    PageResponseList<Board> getMeFollowingBoards(String cursor) throws PinterestException;

    /**
     *
     * get boards that the authenticated user follows
     *
     * @param cursor cursor from where boards are to be fetched
     * @param fields array of specific fields required to be queried from Pinterest
     *
     * @return {@link PageResponseList<Board>}
     *
     * @throws PinterestException when Pinterest is unavailable or sends an error
     */
    PageResponseList<Board> getMeFollowingBoards(String cursor, String[] fields) throws PinterestException;

    /**
     *
     * search authenticated user's boards
     *
     * @param query query string for the boards to be searched
     * @param cursor cursor from where boards are to be searched
     *
     * @return {@link PageResponseList<Board>}
     *
     * @throws PinterestException when Pinterest is unavailable or sends an error
     */
    PageResponseList<Board> searchMeBoards(String query, String cursor) throws PinterestException;

    /**
     *
     * search authenticated user's boards
     *
     * @param query query string for the boards to be searched
     * @param cursor cursor from where boards are to be searched
     * @param fields array of specific fields required to be queried from Pinterest
     *
     * @return {@link PageResponseList<Board>}
     *
     * @throws PinterestException when Pinterest is unavailable or sends an error
     */
    PageResponseList<Board> searchMeBoards(String query, String cursor, String[] fields) throws PinterestException;

    /**
     *
     * Get pins that the authenticated user has liked
     *
     * @param cursor cursor from where pins are to be fetched
     *
     * @return {@link PageResponseList<Pin>}
     *
     * @throws PinterestException when Pinterest is unavailable or sends an error
     */
    PageResponseList<Pin> getMeLikedPins(String cursor) throws PinterestException;

    /**
     *
     * Get pins that the authenticated user has liked
     *
     * @param cursor cursor from where pins are to be fetched
     * @param fields array of specific fields required to be queried from Pinterest
     *
     * @return {@link PageResponseList<Pin>}
     *
     * @throws PinterestException when Pinterest is unavailable or sends an error
     */
    PageResponseList<Pin> getMeLikedPins(String cursor, String[] fields) throws PinterestException;

    /**
     *
     * Get pins of the authenticated user
     *
     * @param cursor cursor from where pins are to be fetched
     *
     * @return {@link PageResponseList<Pin>}
     *
     * @throws PinterestException when Pinterest is unavailable or sends an error
     */
    PageResponseList<Pin> getMePins(String cursor) throws PinterestException;

    /**
     *
     * Get pins of the authenticated user
     *
     * @param cursor cursor from where pins are to be fetched
     * @param fields array of specific fields required to be queried from Pinterest
     *
     * @return {@link PageResponseList<Pin>}
     *
     * @throws PinterestException when Pinterest is unavailable or sends an error
     */
    PageResponseList<Pin> getMePins(String cursor, String[] fields) throws PinterestException;

    /**
     *
     * search authenticated user's pins
     *
     * @param query query string for the pins to be searched
     * @param cursor cursor from where pins are to be searched
     *
     * @return {@link PageResponseList<Pin>}
     *
     * @throws PinterestException when Pinterest is unavailable or sends an error
     */
    PageResponseList<Pin> searchMePins(String query, String cursor) throws PinterestException;

    /**
     *
     * search authenticated user's pins
     *
     * @param query query string for the pins to be searched
     * @param cursor cursor from where pins are to be searched
     * @param fields array of specific fields required to be queried from Pinterest
     *
     * @return {@link PageResponseList<Pin>}
     *
     * @throws PinterestException when Pinterest is unavailable or sends an error
     */
    PageResponseList<Pin> searchMePins(String query, String cursor, String[] fields) throws PinterestException;

    /**
     *
     * Get the interests the authenticated user follows
     *
     * @param cursor cursor from where interests are to be fetched
     *
     * @return {@link PageResponseList<Interest>}
     *
     * @throws PinterestException when Pinterest is unavailable or sends an error
     */
    PageResponseList<Interest> getMeInterests(String cursor) throws PinterestException;

    /**
     *
     * Get the list of users authenticated user follows
     *
     * @param cursor cursor from where followers are to be fetched
     *
     * @return {@link PageResponseList<User>}
     *
     * @throws PinterestException when Pinterest is unavailable or sends an error
     */
    PageResponseList<User> getMeFollowing(String cursor) throws PinterestException;

    /**
     *
     * Get the list of users authenticated user follows
     *
     * @param cursor cursor from where followers are to be fetched
     * @param fields array of specific fields required to be queried from Pinterest
     *
     * @return {@link PageResponseList<User>}
     *
     * @throws PinterestException when Pinterest is unavailable or sends an error
     */
    PageResponseList<User> getMeFollowing(String cursor, String[] fields) throws PinterestException;

    /**
     *
     * Get the list of followers of the authenticated user
     *
     * @param cursor cursor from where followers are to be fetched
     * @param fields array of specific fields required to be queried from Pinterest
     *
     * @return {@link PageResponseList<User>}
     *
     * @throws PinterestException when Pinterest is unavailable or sends an error
     */
    PageResponseList<User> getMeFollowers(String cursor, String[] fields) throws PinterestException;

    /**
     *
     * Get the list of followers of the authenticated user
     *
     * @param cursor cursor from where followers are to be fetched
     *
     * @return {@link PageResponseList<User>}
     *
     * @throws PinterestException when Pinterest is unavailable or sends an error
     */
    PageResponseList<User> getMeFollowers(String cursor) throws PinterestException;

    /**
     *
     * follow a board
     *
     * @param username handle of the creator of the board
     * @param board name of the board to be followed
     *
     * @throws PinterestException when Pinterest is unavailable or sends an error
     */
    void followBoard(String username, String board) throws PinterestException;

    /**
     *
     * unfollow a board
     *
     * @param username handle of the creator of the board
     * @param board name of the board to be unfollowed
     *
     * @throws PinterestException when Pinterest is unavailable or sends an error
     */
    void unfollowBoard(String username, String board) throws PinterestException;

    /**
     *
     * follow a user
     *
     * @param id id or the handle of the user to be followed
     *
     * @throws PinterestException when Pinterest is unavailable or sends an error
     */
    void followUser(String id) throws PinterestException;

    /**
     *
     * unfollow a user
     *
     * @param id id or the handle of the user to be unfollowed
     *
     * @throws PinterestException when Pinterest is unavailable or sends an error
     */
    void unfollowUser(String id) throws PinterestException;

}
