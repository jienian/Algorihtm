public List<String> removeSubfolders(String[] folder) {
    // 首先对文件夹列表进行排序
    Arrays.sort(folder);
    // 创建结果列表
    List<String> result = new ArrayList<>();
    // 将第一个文件夹添加到结果列表中
    result.add(folder[0]);
    // 逐一检查每个文件夹
    for (int i = 1; i < folder.length; i++) {
        // 构建前面文件夹的路径，以 "/" 结尾
        StringBuilder sb = new StringBuilder(result.get(result.size() - 1)).append("/");
        // 如果当前文件夹不是前面文件夹的子文件夹，则将其添加到结果列表中
        if (!folder[i].startsWith(sb.toString())) result.add(folder[i]);
    }
    // 返回结果列表
    return result;
}
public static void main(String[] args) {
    String[] folder = new String[] {"/a", "/a/b", "/c/d", "/c/d/e", "/c/f", "/c/f/g"};
    List<String> result = new Solution().removeSubfolders(folder);
    System.out.println(result);
}

