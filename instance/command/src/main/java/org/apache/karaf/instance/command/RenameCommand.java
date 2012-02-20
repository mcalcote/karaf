/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.karaf.instance.command;

import org.apache.karaf.shell.commands.Argument;
import org.apache.karaf.shell.commands.Command;
import org.apache.karaf.shell.commands.Option;

/**
 * Rename an existing Karaf container instance.
 */
@Command(scope = "instance", name = "rename", description = "Rename an existing container instance.")
public class RenameCommand extends InstanceCommandSupport {

    @Option(name = "-v", aliases = {"--verbose"}, description = "Display actions performed by the command (disabled by default)", required = false, multiValued = false)
    boolean verbose = false;

    @Argument(index = 0, name = "name", description = "The name of the container instance to rename", required = true, multiValued = false)
    String instance = null;

    @Argument(index = 1, name = "new-name", description = "The new name of the container instance", required = true, multiValued = false)
    String newName = null;

    protected Object doExecute() throws Exception {
        getInstanceService().renameInstance(instance, newName, verbose);
        return null;
    }

}
