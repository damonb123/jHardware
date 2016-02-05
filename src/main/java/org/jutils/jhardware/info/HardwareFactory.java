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
package org.jutils.jhardware.info;

import org.jutils.jhardware.info.bios.unix.UnixBiosInfo;
import org.jutils.jhardware.info.bios.windows.WindowsBiosInfo;
import org.jutils.jhardware.info.memory.unix.UnixMemoryInfo;
import org.jutils.jhardware.info.memory.windows.WindowsMemoryInfo;
import org.jutils.jhardware.info.motherboard.unix.UnixMotherboardInfo;
import org.jutils.jhardware.info.motherboard.windows.WindowsMotherboardInfo;
import org.jutils.jhardware.info.processor.unix.UnixProcessorInfo;
import org.jutils.jhardware.info.processor.windows.WindowsProcessorInfo;
import org.jutils.jhardware.util.OSDetector;

/**
 * Factory class to get the right information
 *
 * @author Javier Garcia Alonso
 */
public class HardwareFactory {

    public static HardwareInfo get(InfoType type) {
        switch (type) {
            case PROCESSOR:
                if (OSDetector.isWindows()) {
                    return new WindowsProcessorInfo();
                } else if (OSDetector.isUnix()) {
                    return new UnixProcessorInfo();
                }
            case MEMORY:
                if (OSDetector.isWindows()) {
                    return new WindowsMemoryInfo();
                } else if (OSDetector.isUnix()) {
                    return new UnixMemoryInfo();
                }
            case BIOS:
                if (OSDetector.isWindows()) {
                    return new WindowsBiosInfo();
                } else if (OSDetector.isUnix()) {
                    return new UnixBiosInfo();
                }
            case MOTHERBOARD:
                if (OSDetector.isWindows()) {
                    return new WindowsMotherboardInfo();
                } else if (OSDetector.isUnix()) {
                    return new UnixMotherboardInfo();
                }
            default:
                throw new IllegalArgumentException("Type of hardware not supported: " + type);
        }
    }
}
