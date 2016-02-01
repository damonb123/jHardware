/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jutils.jhardware.info.bios;

import java.util.Map;
import org.jutils.jhardware.info.HardwareInfo;
import org.jutils.jhardware.model.BiosInfo;

/**
 * Information related to BIOS
 * 
 * @author Javier Garcia Alonso
 */
public abstract class AbstractBiosInfo implements HardwareInfo { 

    public BiosInfo getInfo() {
        return buildFromDataMap(parseInfo());
    }
    
    abstract protected Map<String, String> parseInfo();
    
    protected BiosInfo buildFromDataMap(Map<String, String> dataMap) {
        BiosInfo info = new BiosInfo();
        /*info.setFullInfo(dataMap);
        if (dataMap != null && !dataMap.isEmpty()) {
            info.setAvailableMemory(dataMap.get("MemAvailable"));
            info.setFreeMemory(dataMap.get("MemFree"));
            info.setTotalMemory(dataMap.get("MemTotal"));
        }*/
        
        return info;
    }
}