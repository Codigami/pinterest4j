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

package pinterest4j.util.http;

import java.io.File;
import java.io.Serializable;

/**
 * Entity to represent name-value pair for query params
 *
 * Created by Aniket Divekar.
 */
public class QueryParam implements Serializable{

    private static final long serialVersionUID = 6073914120759451986L;
    private String key;
    private String value;
    private File file;

    public QueryParam(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public QueryParam(String key, File value) {
        this.key = key;
        this.file = value;
    }

    public QueryParam(String name, int value) {
        this.key = name;
        this.value = String.valueOf(value);
    }

    public QueryParam(String name, long value) {
        this.key = name;
        this.value = String.valueOf(value);
    }

    public QueryParam(String name, double value) {
        this.key = name;
        this.value = String.valueOf(value);
    }

    public QueryParam(String name, boolean value) {
        this.key = name;
        this.value = String.valueOf(value);
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    public File getFile() {
        return file;
    }

    public boolean isFile() {
        return this.file != null;
    }

    public static boolean containsFile(QueryParam[] params) {
        boolean containsFiles = false;
        for(QueryParam param : params) {
            if (param.isFile()) {
                containsFiles = true;
                break;
            }
        }
        return containsFiles;
    }

    /**
     * @return content-type of the file
     */
    public String getContentType() {
        if (!isFile()) {
            throw new IllegalStateException("input param "+ this.key + "'s value not a file");
        }
        String contentType;
        String extensions = file.getName();
        int index = extensions.lastIndexOf(".");
        if (-1 == index) {
            // no extension
            contentType = HttpUtil.CONTENT_TYPE_OCTET;
        } else {
            extensions = extensions.substring(extensions.lastIndexOf(".") + 1).toLowerCase();
            if (extensions.length() == 3) {
                if ("gif".equals(extensions)) {
                    contentType = HttpUtil.CONTENT_TYPE_GIF;
                } else if ("png".equals(extensions)) {
                    contentType = HttpUtil.CONTENT_TYPE_PNG;
                } else if ("jpg".equals(extensions)) {
                    contentType = HttpUtil.CONTENT_TYPE_JPEG;
                } else {
                    contentType = HttpUtil.CONTENT_TYPE_OCTET;
                }
            } else if (extensions.length() == 4) {
                if ("jpeg".equals(extensions)) {
                    contentType = HttpUtil.CONTENT_TYPE_JPEG;
                } else {
                    contentType = HttpUtil.CONTENT_TYPE_OCTET;
                }
            } else {
                contentType = HttpUtil.CONTENT_TYPE_OCTET;
            }
        }
        return contentType;
    }
}
