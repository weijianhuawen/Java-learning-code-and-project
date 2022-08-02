 // 初始化编辑器
 let editor = editormd("editor", {
    // 这里的尺寸必须在这里设置. 设置样式会被 editormd 自动覆盖掉. 
    width: "100%",
    // 设定编辑器高度
    height: "calc(100% - 50px)",
    // 编辑器中的初始内容
    markdown: "# 在这里写下一篇博客",
    // 指定 editor.md 依赖的插件路径
    path: "editor.md/lib/"
});