import java.util.List;
import java.util.Stack;

public class Sort {
    /**
     * 冒泡排序
     * @param array 排序对象
     */
    //优化前
    public void bubbleSort1(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {    //排序趟数
            for (int j = 1; j < array.length - i; j++) {
                //如果j所有处元素小于j-1索引处元素，则交换，否则不交换
                if (array[j] < array[j - 1]) {
                    swap(array, j, j-1);
                }
            }
        }
    }
    //优化后
    public void bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {    //排序趟数
            boolean flag = false;                       //标记
            for (int j = 1; j < array.length - i; j++) {
                //如果j所有处元素小于j-1索引处元素，则交换，否则不交换
                if (array[j] < array[j - 1]) {
                    swap(array, j, j-1);
                    flag = true;                        //发生交换将标记置为真
                }
            }
            if (!flag) break;                           //一趟冒泡排序后flag为false说明数组已经有序了
        }
    }

    /**
     * 交换数组两个元素
     * @param arr 目标数组
     * @param index1 交换下标1
     * @param index2 交换下标2
     */
    public void swap(int[] arr, int index1, int index2) {
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }
    /**
     * 选择排序
     * @param array 待排序序列
     */
    public void selectSort(int[] array) {
        int minIndex = 0;                                    //存放最小元素的下标
        for (int i = 0; i < array.length - 1; i++) {
            minIndex = i;                                   //默认为i下标
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;                           //获取i下标后面更小元素的下标
                }
            }
            swap(array, i, minIndex);                       //交换
        }
    }

    public int[] selectSort2(int[] nums) {
        int min = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            min = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[min]) {
                    min = j;
                }
            }
            swap(nums, i, min);
        }
        return nums;
    }

    /**
     * 直接插入排序
     * @param array 待排序对象
     */
    public void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int insert = array[i];                      //待插入元素
            int index = i - 1;                          //待插入元素前一个元素下标
            while (index >= 0) {
                if (array[index] > insert) {
                    array[index + 1] = array[index];          //在数组下标合法范围内，比较insert与index位置元素大小，如果index位置元素更大则将此元素放入index+1位置，index--
                    index--;
                }else {
                    break;                                  //否则结束插入
                }
            }
            array[index+1] = insert;                          //将insert插入index+1位置处
        }
    }
    /**
     * 希尔排序
     * @param array 待排序序列
     * @param gap 组数
     */
    public void shell(int[] array,int gap) {
        int insert = 0;
        for (int i = gap; i < array.length; i++) {
            insert = array[i];
            int j = i - gap;
            while (j >= 0) {
                if (array[j] > insert) {
                    array[j + gap] = array[j];
                    j -= gap;
                } else {
                    break;
                }
            }
            array[j + gap] = insert;
        }
    }

    public void shellSort(int[] array) {
        int gap = array.length;
        while (gap > 1) {
            shell(array,gap);
            gap /= 2;
        }
        shell(array,1);//保证最后是1组
    }

    /**
     * 快速排序
     * @param array 待排序数组对象
     */
    public void quickSort(int[] array) {
        quickSortFunc(array, 0, array.length-1);
    }
    private void quickSortFunc(int[] array, int start, int end) {
        if (start >= end) return;
        //1.找基准
        int pivotIndex = findPivot(array, start, end);
        //2.快排基准左边元素序列
        quickSortFunc(array, start, pivotIndex-1);
        //3.快排基准右边元素序列
        quickSortFunc(array, pivotIndex+1, end);
    }

    /**
     * 快速排序优化
     * @param array 待排序数组
     */
    public void quickSortPlus(int[] array) {
        quickSortFuncPlus(array, 0, array.length-1);
    }
    private void quickSortFuncPlus(int[] array, int start, int end) {
        if (start >= end) return;
        //1.找基准
        int pivotIndex = findPivotPlus(array, start, end);
        //2.快排基准左边元素序列
        quickSortFuncPlus(array, start, pivotIndex-1);
        //3.快排基准右边元素序列
        quickSortFuncPlus(array, pivotIndex+1, end);
    }

    /**
     * 找基准
     * @param array 待排序数组对象
     * @param left 左边界
     * @param right 右边界
     * @return 基准值下标
     */
    private int findPivot(int[] array, int left, int right) {
        //取左边界元素为基准值，该位置“挖坑”
        int pivot = array[left];
        int start = left;
        int end = right;

        while (start < end) {
            //从右边界end开始找比基准值小的元素
            while (start < end && array[end] >= pivot) {
                end--;
            }
            //填上一个坑start，此时end位置挖坑
            array[start] = array[end];
            //从左边界start开始找比基准值大的元素
            while (start < end && array[start] <= pivot) {
                start++;
            }
            //填上一个坑end，此时start位置挖坑
            array[end] = array[start];
        }
        //start与end相等时的位置，即基准值位置
        array[start] = pivot;
        return start;
    }

    /**
     * 找基准 三数取中优化
     * @param array 待排序数组对象
     * @param left 左边界
     * @param right 右边界
     * @return 基准值下标
     */
    private int findPivotPlus(int[] array, int left, int right) {
        int mid = left + ((right - left) >>> 1);
        //调整左边界元素为left  mid  right对应元素的中间大小值
        if (array[left] <= array[right]) {
            //mid left right
            if (array[mid] < array[left]) swap(array, left, left);
            //left right mid
            else if (array[mid] > array[right]) swap(array, left, right);
            //left mid right
            else swap(array, left, mid);
        } else {
            //right left mid
            if (array[mid] > array[left]) swap(array, left, left);
            //mid right left
            else if (array[mid] < array[right]) swap(array, left, right);
            //right mid left
            else swap(array, left, mid);
        }
        int pivot = array[left];
        int start = left;
        int end = right;

        while (start < end) {
            //从右边界end开始找比基准值小的元素
            while (start < end && array[end] >= pivot) {
                end--;
            }
            //填上一个坑start，此时end位置挖坑
            array[start] = array[end];
            //从左边界start开始找比基准值大的元素
            while (start < end && array[start] <= pivot) {
                start++;
            }
            //填上一个坑end，此时start位置挖坑
            array[end] = array[start];
        }
        //start与end相等时的位置，即基准值位置
        array[start] = pivot;
        return start;
    }

    /**
     * 快速排序非递归实现
     * @param array 待排序数组
     */
    public void quickSortIter(int[] array) {
        Stack<Integer> stack = new Stack<>();
        int left = 0;
        int right = array.length - 1;
        //分别将左右边界下标入栈，取出时，注意出栈顺序与入栈顺序相反
        stack.push(left);
        stack.push(right);
        while (!stack.isEmpty()) {
            right = stack.pop();
            left = stack.pop();
            int pivotIndex = findPivotPlus(array, left, right);
            //基准左右序列的元素个数大于或等于两个则继续对左右序列找基准，确定位置，否则没必要再找基准
            if (pivotIndex > left + 1) {
                stack.push(left);
                stack.push(pivotIndex - 1);
            }
            if (pivotIndex < right - 1) {
                stack.push(pivotIndex + 1);
                stack.push(right);
            }
        }
    }

    /**
     * 前后遍历找基准
     * @param array 待排序数组对象
     * @param left 左边界
     * @param right 右边界
     * @return 基准值下标
     */
    public int test1(int[] array, int left, int right) {
        int div = left + 1;
        int pivot = array[left];
        for (int i = left + 1; i <= right; i++) {
            if (array[i] < pivot) {
                swap(array, div, i);
                div++;
            }
        }
        swap(array, left, div - 1);
        return div - 1;
    }
    /**
     * 挖坑法找基准
     * @param array 待排序数组对象
     * @param left 左边界
     * @param right 右边界
     * @return 基准值下标
     */
    public int test2(int[] array, int left, int right) {
        //取左边界元素为基准值，该位置“挖坑”
        int pivot = array[left];
        int start = left;
        int end = right;

        while (start < end) {
            //从右边界end开始找比基准值小的元素
            while (start < end && array[end] >= pivot) {
                end--;
            }
            //填上一个坑start，此时end位置挖坑
            array[start] = array[end];
            //从左边界start开始找比基准值大的元素
            while (start < end && array[start] <= pivot) {
                start++;
            }
            //填上一个坑end，此时start位置挖坑
            array[end] = array[start];
        }
        //start与end相等时的位置，即基准值位置
        array[start] = pivot;
        return start;
    }

    /**
     * Hoare 法找基准
     * @param array 待排序数组对象
     * @param left 左边界
     * @param right 右边界
     * @return 基准值下标
     */
    public int test3(int[] array, int left, int right) {
        int pivot = array[left];
        int start = left;
        int end = right;
        while (start < end) {
            //从右边界开始找到比基准值小的元素，即遇到比基准值大的，end--
            while (start < end && array[end] >= pivot) {
                end--;
            }
            //从左边界开始找到比基准值大的元素，即遇到比基准值小的，start++
            while (start < end && array[start] <= pivot) {
                start++;
            }
            //交换这两个元素，将比基准值大的元素调整至右边，小的调整至左边
            swap(array, start, end);
        }
        //srart与end相遇,为基准值位置，将基准值与相遇出的元素交换
        swap(array,start, left);
        return start;
    }

    /**
     * 归并排序
     * @param array 待排序数组对象
     */
    public void mergeSort(int[] array) {
        mergeSortFunc(array, 0, array.length-1);
    }
    private void mergeSortFunc(int[] array, int start, int end) {
        if (start >= end) return;
        int mid = start +((end - start) >>> 1);
        //对数组进行分解
        mergeSortFunc(array, start, mid);
        mergeSortFunc(array, mid + 1, end);
        //对数组进行有序合并
        merge(array, start, mid, end);
    }

    /**
     * 合并有序序列
     * @param arrray 目标序列
     * @param left 第一组序列左边界
     * @param mid   第一组序列右边界（记为中点）
     * @param right 第二组序列右边界
     */
    private void merge(int[] arrray, int left, int mid, int right){
        int[] tmp = new int[right - left + 1];//临时数组，用来存放合并后的数组
        int start1 = left;
        int start2 = mid + 1;
        int index = 0;
        while (start1 <= mid && start2 <= right) {
            //有序向临时数组中传入数据
            if (arrray[start1] <= arrray[start2]) {
                tmp[index++] = arrray[start1++];
            } else {
                tmp[index++] = arrray[start2++];
            }
        }
        //将剩下的元素放入临时数组中
        while (start1 <= mid) tmp[index++] = arrray[start1++];
        while (start2 <= right) tmp[index++] = arrray[start2++];
        
        //将临时数组中的元素对应拷贝到array中
        for (int i = 0; i < index; i++) {
            arrray[i + left] = tmp[i];
        }
    }

    /**
     * 归并排序非递归
     * @param array 待排序数组
     */
    public void mergeSortIter(int[] array) {
        //对待排序数组进行分组，每组元素个数从1开始，进行两组为一单位的有序合并，以合并完成后的数组为一组，继续进行有序数组合并，直到整个数组有序为止
        int gap = 1;//每组元素个数
        while (gap < array.length){
            for (int i = 0; i < array.length; i += gap * 2) {
                //合并在同一个数组上相邻两段序列需要以下3个参数
                int left = i;               //第一组第一个元素下标
                int mid = left + gap - 1;   //第一组最后一个元素下标
                int right = mid + gap;      //第二组最后一个元素下标
                //合并时两段序列元素个数不一定相等，合并前需要验证mid和right是否越界，如果越界则改为数组最后一个元素的下标
                if (mid >= array.length) mid = array.length - 1;
                if (right >= array.length) right = array.length - 1;
                //开始合并两段序列
                merge(array, left, mid, right);
            }
            gap *= 2;//数组合并后，每组元素个数为上一次一组元素个数的2倍
        }
    }

    /**
     * 堆排序
     * @param array 待排序数组
     */
    public void heapSort(int[] array) {
        //1.升序排列，需要建造大堆，将待排序数组转换成大根堆
        creatBigHeap(array);
        int end = array.length - 1;
        //2.堆顶元素0~end下标对应数组中的最大值，将堆顶元素与end出元素交换，则该元素已经排好序了
        while (end > 0) {
            //3.堆顶元素与end出元素交换
            swap(array, 0, end);
            //4.堆顶元素处大根堆被破坏，其他树依然是大根堆，所以需要对堆顶元素进行向下调整，但要将已经排好序的元素排除在外
            shiftDown(array, 0, end);//除去上一次排好序的元素，长度为end
            end--;
        }

    }

    /**
     * 根据数组创建大根堆
     * @param array 目标数组
     */
    private void creatBigHeap(int[] array) {
        int child = array.length - 1;
        int parent = (child - 1) / 2;
        for (int i = parent; i >= 0 ; i--) {
            shiftDown(array, i, array.length);
        }
    }

    /**
     * 向下调整
     * @param array 目标数组
     * @param parent 父亲结点下标
     * @param len 调整堆的结点数目（前len个不能超过数组长度）
     */
    private void shiftDown(int[] array, int parent, int len) {
        int child = 2 * parent + 1;
        while (child < len) {
            if (child + 1 < len && array[child] < array[child+1]) child++;
            if (array[child] > array[parent]) {
                swap(array, parent, child);
                parent = child;
                child = 2 * parent + 1;
            } else {
                break;
            }
        }
    }

    /**
     * 合并两个有序的数组
     * @param array1 有序数组1
     * @param array2 有序数组2
     * @return 合并后的有序数组
     */
    public int[] mergeArray(int[] array1, int[] array2) {
        int[] tmp = new int[array1.length+array2.length];//临时数组，用来存放合并后的数组

        int start1 = 0;
        int start2 = 0;
        int index = 0;
        //较小的元素存在前
        while (start1 < array1.length && start2 < array2.length) {
            if (array1[start1] <= array2[start2]) tmp[index++] = array1[start1++];
            else tmp[index++] = array2[start2++];
        }
        //将剩余的元素依次存入tmp
        while (start1 < array1.length) tmp[index++] = array1[start1++];
        while (start2 < array2.length) tmp[index++] = array2[start2++];

        return tmp;
    }
}

