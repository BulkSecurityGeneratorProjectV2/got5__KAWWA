package awl.frontsolutions

import geb.spock.GebSpec
import spock.lang.Unroll

class DownloadPageSpec extends GebSpec{
    def "Email field should have a type=email"(){
        when:
        go "/Portal/Download"

        then:
        $("form[id='downloadForm'] input[type='email']") .size() == 1
    }
}

