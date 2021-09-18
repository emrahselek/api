package post_http_request_method;

import base_urls.AgromonitoringApiBaseUrl;
import org.junit.Test;

public class post03 extends AgromonitoringApiBaseUrl {
    /*
           Given
        "http://api.agromonitoring.com/agro/1.0/polygons?appid=f4ffe3b2ef1fcb3600ab1d7fbc88c2f0"
                                 {
                                           "name":"Polygon Sample",
                                           "geo_json":{
                                              "type":"Feature",
                                              "properties":{},
                                              "geometry":{
                                                 "type":"Polygon",
                                                 "coordinates":[
                                                    [
                                                       [-121.1958,37.6683],
                                                       [-121.1779,37.6687],
                                                       [-121.1773,37.6792],
                                                       [-121.1958,37.6792],
                                                       [-121.1958,37.6683]
                                                    ]
                                                 ]
                                              }
                                           }
                                        }
        When
         I send POST Request to the Url
    Then
        Assert Status Code (201)
        And Response Body should be like {
                                            "id": "5fd8c383714b523b2ce1f154",
                                            "geo_json": {
                                                "geometry": {
                                                    "coordinates": [
                                                        [
                                                            [
                                                                -121.1958,
                                                                37.6683
                                                            ],
                                                            [
                                                                -121.1779,
                                                                37.6687
                                                            ],
                                                            [
                                                                -121.1773,
                                                                37.6792
                                                            ],
                                                            [
                                                                -121.1958,
                                                                37.6792
                                                            ],
                                                            [
                                                                -121.1958,
                                                                37.6683
                                                            ]
                                                        ]
                                                    ],
                                                    "type": "Polygon"
                                                },
                                                "type": "Feature",
                                                "properties": {
                                                }
                                            },
                                            "name": "Polygon Sample",
                                            "center": [
                                                -121.1867,
                                                37.67385
                                            ],
                                            "area": 190.9484,
                                            "user_id": "5fd8c02a3da20c000759e0f8",
                                            "created_at": 1608041347
                                        }
     */

    @Test
    public void post03(){
        //1.Step Set the url
    spec.pathParams("first", "agro", "second", 1.0, "third", "polygons").
            queryParam("appid","f4ffe3b2ef1fcb3600ab1d7fbc88c2f0");

        //2.Step : Set the expected data
    }
}
