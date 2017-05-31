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

import pinterest4j.entity.Pin;
import pinterest4j.util.exception.PinterestException;

import java.io.File;

/**
 * Provides all the interfaces for Pinterest <b>Pin</b> APIs
 *
 * Created by Aniket Divekar.
 */
public interface PinterestPin {

    /**
     *
     * Get {@link Pin} with default fields
     * Default fields returned by Pinterest are:
     * <ul>
     *  <li>id</li>
     *  <li>link</li>
     *  <li>note</li>
     *  <li>url</li>
     * </ul>
     *
     * @param id id of the pin
     *
     * @return {@link Pin}
     * @throws PinterestException when Pinterest is unavailable or sends an error
     */
    Pin getPin(String id) throws PinterestException;

    /**
     *
     * Get {@link Pin} with with specific fields
     * Possible fields that can be returned by Pinterest are:
     * <ul>
     *  <li>id</li>
     *  <li>creator</li>
     *  <li>url</li>
     *  <li>media</li>
     *  <li>created_at</li>
     *  <li>original_link</li>
     *  <li>note</li>
     *  <li>color</li>
     *  <li>link</li>
     *  <li>board</li>
     *  <li>image</li>
     *  <li>counts</li>
     * </ul>
     *
     * <b>NOTE: <i>metadata</i> and <i>attribution</i> fields are planned to be included in future release</b>
     *
     * @param id id of the pin
     * @param fields array of specific fields required to be queried from Pinterest
     *
     * @return {@link Pin}
     * @throws PinterestException when Pinterest is unavailable or sends an error
     */
    Pin getPin(String id, String[] fields) throws PinterestException;

    /**
     *
     * Create {@link Pin} and get pin's default fields as response after creating the pin
     * Default fields returned by Pinterest are:
     * <ul>
     *  <li>id</li>
     *  <li>link</li>
     *  <li>note</li>
     *  <li>url</li>
     * </ul>
     *
     * @param username handle of the creator
     * @param board name of the board where pin is to be created
     * @param note note for the board
     * @param link link for the board
     * @param imageUrl link to the image you want to Pin
     *
     * @return {@link Pin}
     * @throws PinterestException when Pinterest is unavailable or sends an error
     */
    Pin createPinWithImageUrl(String username, String board, String note, String link, String imageUrl) throws PinterestException;

    /**
     *
     * Create {@link Pin} and get pin's specified fields as response after creating the pin
     * Default fields returned by Pinterest are:
     * <ul>
     *  <li>id</li>
     *  <li>link</li>
     *  <li>note</li>
     *  <li>url</li>
     * </ul>
     *
     * @param username handle of the creator
     * @param board name of the board where pin is to be created
     * @param note note for the board
     * @param link link for the board
     * @param imageUrl link to the image you want to Pin
     * @param fields array of specific fields required to be queried from Pinterest
     *
     * @return {@link Pin}
     * @throws PinterestException when Pinterest is unavailable or sends an error
     */
    Pin createPinWithImageUrl(String username, String board, String note, String link, String imageUrl, String[] fields) throws PinterestException;

    /**
     *
     * Create {@link Pin} and get pin's default fields as response after creating the pin
     * Default fields returned by Pinterest are:
     * <ul>
     *  <li>id</li>
     *  <li>link</li>
     *  <li>note</li>
     *  <li>url</li>
     * </ul>
     *
     * @param username handle of the creator
     * @param board name of the board where pin is to be created
     * @param note note for the board
     * @param link link for the board
     * @param imageUrl link of a Base64 encoded image you want to Pin
     *
     * @return {@link Pin}
     * @throws PinterestException when Pinterest is unavailable or sends an error
     */
    Pin createPinWithBase64EncodedImageUrl(String username, String board, String note, String link, String imageUrl) throws PinterestException;

    /**
     *
     * Create {@link Pin} and get pin's specified fields as response after creating the pin
     * Default fields returned by Pinterest are:
     * <ul>
     *  <li>id</li>
     *  <li>link</li>
     *  <li>note</li>
     *  <li>url</li>
     * </ul>
     *
     * @param username handle of the creator
     * @param board name of the board where pin is to be created
     * @param note note for the board
     * @param link link for the board
     * @param imageUrl link of a Base64 encoded image you want to Pin
     * @param fields array of specific fields required to be queried from Pinterest
     *
     * @return {@link Pin}
     * @throws PinterestException when Pinterest is unavailable or sends an error
     */
    Pin createPinWithBase64EncodedImageUrl(String username, String board, String note, String link, String imageUrl, String[] fields) throws PinterestException;

    /**
     *
     * Create {@link Pin} and get pin's default fields as response after creating the pin
     * Default fields returned by Pinterest are:
     * <ul>
     *  <li>id</li>
     *  <li>link</li>
     *  <li>note</li>
     *  <li>url</li>
     * </ul>
     *
     * @param username handle of the creator
     * @param board name of the board where pin is to be created
     * @param note note for the pin
     * @param link link for the pin
     * @param image image file you want to Pin
     *
     * @return {@link Pin}
     * @throws PinterestException when Pinterest is unavailable or sends an error
     */
    Pin createPinWithImageFile(String username, String board, String note, String link, File image) throws PinterestException;

    /**
     *
     * Create {@link Pin} and get pin's specified fields as response after creating the pin
     * Default fields returned by Pinterest are:
     * <ul>
     *  <li>id</li>
     *  <li>link</li>
     *  <li>note</li>
     *  <li>url</li>
     * </ul>
     *
     * @param username handle of the creator
     * @param board name of the board where pin is to be created
     * @param note note for the pin
     * @param link link for the pin
     * @param image image file you want to Pin
     * @param fields array of specific fields required to be queried from Pinterest
     *
     * @return {@link Pin}
     * @throws PinterestException when Pinterest is unavailable or sends an error
     */
    Pin createPinWithImageFile(String username, String board, String note, String link, File image, String[] fields) throws PinterestException;

    /**
     *
     * Edit {@link Pin} and get pin default fields as response after editing the pin
     * Default fields returned by Pinterest are:
     * <ul>
     *  <li>id</li>
     *  <li>link</li>
     *  <li>note</li>
     *  <li>url</li>
     * </ul>
     *
     * @param id id of the pin
     * @param username handle of the creator
     * @param board name of the board where the pin needs to be edited
     * @param note new note for the pin
     * @param link new link for the pin
     *
     * @return {@link Pin}
     * @throws PinterestException when Pinterest is unavailable or sends an error
     */
    Pin editPin(String id, String username, String board, String note, String link) throws PinterestException;

    /**
     *
     * Edit {@link Pin} and get pin's specified fields as response after editing the pin
     * Default fields returned by Pinterest are:
     * <ul>
     *  <li>id</li>
     *  <li>link</li>
     *  <li>note</li>
     *  <li>url</li>
     * </ul>
     *
     * @param id id of the pin
     * @param username handle of the creator
     * @param board name of the board where the pin needs to be edited
     * @param note new note for the pin
     * @param link new link for the pin
     * @param fields array of specific fields required to be queried from Pinterest
     *
     * @return {@link Pin}
     * @throws PinterestException when Pinterest is unavailable or sends an error
     */
    Pin editPin(String id, String username, String board, String note, String link, String[] fields) throws PinterestException;

    /**
     *
     * delete the pin
     *
     * @param id id of the pin to be deleted
     *
     * @throws PinterestException when Pinterest is unavailable or sends an error
     */
    void deletePin(String id) throws PinterestException;
}
