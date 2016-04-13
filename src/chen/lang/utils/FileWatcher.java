package chen.lang.utils;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.FileSystems;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

import chen.lang.bean.FileWatcher_vo;

/**
 * 文件系统监控 热加载class
 */
public class FileWatcher {

	public static void main(String[] args) {
		fileWather();
	}

	public static void fileWather() {
		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					// 项目路径，线上线下不一样
					String user_dir = System.getProperty("user.dir");
					String user_home = System.getProperty("user.home");
					String path = user_dir + "/src/classes";
					WatchService watchService = FileSystems.getDefault().newWatchService();
					Paths.get(path).register(watchService, StandardWatchEventKinds.ENTRY_CREATE,
							StandardWatchEventKinds.ENTRY_DELETE, StandardWatchEventKinds.ENTRY_MODIFY);
					while (true) {
						WatchKey key = watchService.take();
						for (WatchEvent<?> event : key.pollEvents()) {
							initFunctions(path);
						}
						if (!key.reset()) {
							break;
						}
					}
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		}).start();
	}

	private static void initFunctions(String root)
			throws MalformedURLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		File rootDir = new File(root);

		@SuppressWarnings("resource")
		URLClassLoader loader = new URLClassLoader(new URL[] { new URL("file:" + root) });
		String packageName = "chen.lang.bean.";
		String[] fileList = rootDir.list();
		for (String fileName : fileList) {
			if (fileName.contains("class")) {
				System.out.println(fileName);
				String[] names = fileName.split("\\.");
				String classname = names[0];

				FileWatcher_vo c = (FileWatcher_vo) loader.loadClass(packageName + classname).newInstance();
				c.say();
			}
		}
	}

}
