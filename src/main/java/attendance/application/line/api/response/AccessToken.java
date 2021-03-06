/*
 * Copyright 2016 LINE Corporation
 *
 * LINE Corporation licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package attendance.application.line.api.response;

public final class AccessToken {

    public final String scope;
    public final String access_token;
    public final String token_type;
    public final Integer expires_in;
    public final String refresh_token;
    public final String id_token;

    public AccessToken(String scope, String access_token, String token_type, Integer expires_in, String refresh_token, String id_token) {
        this.scope = scope;
        this.access_token = access_token;
        this.token_type = token_type;
        this.expires_in = expires_in;
        this.refresh_token = refresh_token;
        this.id_token = id_token;
    }

    @Override
    public String toString() {
        return "AccessToken [scope=" + scope + ", access_token=" + access_token + ", token_type=" + token_type
                + ", expires_in=" + expires_in + ", refresh_token=" + refresh_token + ", id_token=" + id_token + "]";
    }

}
