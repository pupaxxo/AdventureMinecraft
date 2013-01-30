package com.pupaxxo.adventureminecraft.helper;

import java.io.InputStream;
import java.net.URL;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.pupaxxo.adventureminecraft.core.Reference;

import cpw.mods.fml.common.Loader;

public class VersionHelper implements Runnable{
	public int result;
	public static final byte UNINITIALIZED = 0;
	public static final byte CURRENT = 1;
	public static final byte OUTDATED = 2;
	public static final byte ERROR = 3;
	public static final byte FINAL_ERROR = 4;
	public static Properties remoteVersionProperties = new Properties();
	public static String remoteVersion = null;
    public static String remoteUpdateLocation = null;
    private static VersionHelper instance = new VersionHelper();
    
	@Override
	public void run() {
	    	InputStream remoteVersionRepoStream = null;
	        result = UNINITIALIZED;

	        try {
	            URL remoteVersionURL = new URL("http://raw.github.com/pupaxxo/AdventureMinecraft/master/version.xml");
	            remoteVersionRepoStream = remoteVersionURL.openStream();
	            remoteVersionProperties.loadFromXML(remoteVersionRepoStream);

	            String remoteVersionProperty = remoteVersionProperties.getProperty(Loader.instance().getMCVersionString());

	            if (remoteVersionProperty != null) {
	                remoteVersion = remoteVersionProperty.substring(0, remoteVersionProperty.indexOf("|"));
	                remoteUpdateLocation = remoteVersionProperty.substring(remoteVersionProperty.indexOf("|") + 1);
	            }

	            if ((remoteVersion != null) && (remoteVersion.equals(Reference.VERSION))) {
	                result = CURRENT;
	                return;
	            }

	            result = OUTDATED;
	        }
	        catch (Exception e) {
	        	//e.printStackTrace();
	        }
	        finally {
	            if (result == UNINITIALIZED) {
	                result = ERROR;
	            }

	            try {
	                if (remoteVersionRepoStream != null) {
	                    remoteVersionRepoStream.close();
	                }
	            }
	            catch (Exception ex) {
	            }
	        }
	        if (result == ERROR){
	        	LogHelper.log(Level.SEVERE,"Error while checkin version of Adventure Minecraft , current version is " + Reference.VERSION + ".");
	        } else if (result == OUTDATED) {        	
	        	LogHelper.log(Level.WARNING,"Outdated version of Adventure Minecraft, new version " + remoteVersion + " you can download it at " + remoteUpdateLocation + " and you've got the version: " + Reference.VERSION + ".");
	        } else if (result == CURRENT) {
	        	LogHelper.log(Level.INFO,"You've got an updated version of Adventure Minecraft " + Reference.VERSION + ".");
	        } else {
	        	LogHelper.log(Level.SEVERE,"Error while checkin version of Adventure Minecraft , current version is " + Reference.VERSION + ".");
	        }
	}
	public static void execute() {
		new Thread(instance).start();
	}
}
